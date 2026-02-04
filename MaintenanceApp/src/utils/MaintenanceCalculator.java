package utils;

public class MaintenanceCalculator {

    public static double calculate(int length, int breadth, String status) {

        int sqft = length * breadth;

        if (status.equalsIgnoreCase("OPEN")) {
            return sqft * 6;
        } else {
            return sqft * 9;
        }
    }
}
