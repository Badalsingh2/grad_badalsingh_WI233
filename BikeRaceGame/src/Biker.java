import java.util.Map;
import java.util.concurrent.Phaser;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;

class Biker implements Runnable {

    private final String name;
    private final Phaser phaser;
    private final int raceDistance;
    private final AtomicInteger rankingCounter;
    private final Map<Integer, String> leaderboard;

    private final int baseSpeed;

    public Biker(String name,
                 Phaser phaser,
                 int raceDistance,
                 AtomicInteger rankingCounter,
                 Map<Integer, String> leaderboard) {

        this.name = name;
        this.phaser = phaser;
        this.raceDistance = raceDistance;
        this.rankingCounter = rankingCounter;
        this.leaderboard = leaderboard;

        // Each biker has a different base speed
        this.baseSpeed = ThreadLocalRandom.current().nextInt(200, 500);
    }

    @Override
    public void run() {

        // Wait for race start
        phaser.arriveAndAwaitAdvance();

        int distanceCovered = 0;

        while (distanceCovered < raceDistance) {
            try {
                int speedVariation = ThreadLocalRandom.current().nextInt(400, 500);
                int currentSpeed = Math.max(1000, baseSpeed + speedVariation);

                Thread.sleep(currentSpeed);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            distanceCovered += 100;
            System.out.println(name + " completed " + distanceCovered + " meters");
        }

        // Assign rank silently
        int rank = rankingCounter.incrementAndGet();
        leaderboard.put(rank, name);

        phaser.arriveAndDeregister();
    }
}
