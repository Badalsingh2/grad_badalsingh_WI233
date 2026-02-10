import java.util.Map;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Main{

    public static void main(String[] args) {

        int totalBikers = 10;
        int raceDistance = 1000;

        ExecutorService executor = Executors.newFixedThreadPool(totalBikers);

        Phaser phaser = new Phaser(1); // main thread
        AtomicInteger rankingCounter = new AtomicInteger(0);
        Map<Integer, String> leaderboard = new ConcurrentHashMap<>();

        for (int i = 1; i <= totalBikers; i++) {
            phaser.register();
            executor.submit(
                    new Biker(
                            "Biker-" + i,
                            phaser,
                            raceDistance,
                            rankingCounter,
                            leaderboard
                    )
            );
        }

        System.out.println("All bikers ready...");
        System.out.println("🚦 Race starts NOW!\n");

        // Start race
        phaser.arriveAndDeregister();

        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // FINAL leaderboard after ALL finish
        System.out.println("\nFINAL RANKINGS ");
        leaderboard.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(e ->
                        System.out.println("Position " + e.getKey() + " → " + e.getValue())
                );
    }
}
