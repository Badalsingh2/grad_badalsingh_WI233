package dao;

import utils.dbConnection;
import utils.MaintenanceCalculator;

import java.sql.*;

public class PaymentDAO {

    // ✅ Generate Pending Payment Record for All Sites
    public static void generatePendingPayments() {

        try (Connection con = dbConnection.getConnection()) {

            ResultSet rs = con.createStatement().executeQuery(
                    "SELECT * FROM sites"
            );

            while (rs.next()) {

                int siteId = rs.getInt("site_id");
                int length = rs.getInt("length");
                int breadth = rs.getInt("breadth");
                String status = rs.getString("status");

                double amount =
                        MaintenanceCalculator.calculate(length, breadth, status);

                PreparedStatement ps =
                        con.prepareStatement(
                                "INSERT INTO payments(site_id, amount, pending) VALUES(?,?,TRUE)"
                        );

                ps.setInt(1, siteId);
                ps.setDouble(2, amount);

                ps.executeUpdate();
            }

            System.out.println("✅ Pending Payments Generated Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ✅ View Pending Payment Report
    public static void viewPendingPayments() {

        try (Connection con = dbConnection.getConnection()) {

            ResultSet rs =
                    con.createStatement().executeQuery(
                            "SELECT * FROM payments WHERE pending=TRUE"
                    );

            System.out.println("\n===== Pending Payments Report =====");

            while (rs.next()) {

                System.out.println("Payment ID: " + rs.getInt("payment_id"));
                System.out.println("Site ID: " + rs.getInt("site_id"));
                System.out.println("Amount Due: ₹" + rs.getDouble("amount"));
                System.out.println("--------------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
