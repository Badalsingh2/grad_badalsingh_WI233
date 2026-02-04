package dao;

//import db.DBConnection;
import utils.dbConnection;
import utils.MaintenanceCalculator;

import java.sql.*;
import java.util.Scanner;


public class SiteDAO {

    // Insert auto site
    public static void insertSite(int siteId, int length, int breadth) {

        try (Connection con = dbConnection.getConnection()) {

            PreparedStatement ps =
                    con.prepareStatement(
                            "INSERT INTO sites(site_id,owner_id,site_type,length,breadth,status) VALUES(?,?,?,?,?,?)"
                    );

            ps.setInt(1, siteId);
            ps.setNull(2, Types.INTEGER);
            ps.setString(3, "OPEN SITE");
            ps.setInt(4, length);
            ps.setInt(5, breadth);
            ps.setString(6, "OPEN");

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Owner View Site
    public static void viewOwnerSite(int ownerId) {

        try (Connection con = dbConnection.getConnection()) {

            PreparedStatement ps =
                    con.prepareStatement(
                            "SELECT * FROM sites WHERE owner_id=?"
                    );

            ps.setInt(1, ownerId);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n--- Your Site Details ---");

            while (rs.next()) {
                System.out.println("Site ID: " + rs.getInt("site_id"));
                System.out.println("Type: " + rs.getString("site_type"));
                System.out.println("Status: " + rs.getString("status"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Owner Request Update
    public static void requestSiteUpdate(int siteId, String newStatus) {

        try (Connection con = dbConnection.getConnection()) {

            PreparedStatement ps =
                    con.prepareStatement(
                            "INSERT INTO update_requests(site_id,new_status) VALUES(?,?)"
                    );

            ps.setInt(1, siteId);
            ps.setString(2, newStatus);

            ps.executeUpdate();

            System.out.println("✅ Request Sent to Admin!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Admin Approve Requests
    public static void approveOrRejectRequests() {

        try (Connection con = dbConnection.getConnection()) {

            ResultSet rs =
                    con.createStatement().executeQuery(
                            "SELECT * FROM update_requests WHERE approved=FALSE"
                    );

            Scanner sc = new Scanner(System.in);

            System.out.println("\n===== Pending Update Requests =====");

            while (rs.next()) {

                int requestId = rs.getInt("request_id");
                int siteId = rs.getInt("site_id");
                String newStatus = rs.getString("new_status");

                System.out.println("\nRequest ID: " + requestId);
                System.out.println("Site ID: " + siteId);
                System.out.println("Requested Status: " + newStatus);

                System.out.println("1. Approve");
                System.out.println("2. Reject");

                int choice = sc.nextInt();

                if (choice == 1) {

                    // ✅ Approve Request
                    con.createStatement().executeUpdate(
                            "UPDATE sites SET status='" + newStatus + "' WHERE site_id=" + siteId
                    );

                    con.createStatement().executeUpdate(
                            "UPDATE update_requests SET approved=TRUE WHERE request_id=" + requestId
                    );

                    System.out.println("✅ Approved Successfully!");

                } else {

                    // ❌ Reject Request
                    con.createStatement().executeUpdate(
                            "DELETE FROM update_requests WHERE request_id=" + requestId
                    );

                    System.out.println("❌ Request Rejected!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Admin Maintenance Collection
    public static void collectMaintenance(int siteId) {

        try (Connection con = dbConnection.getConnection()) {

            PreparedStatement ps =
                    con.prepareStatement(
                            "SELECT length,breadth,status FROM sites WHERE site_id=?"
                    );

            ps.setInt(1, siteId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                int length = rs.getInt("length");
                int breadth = rs.getInt("breadth");
                String status = rs.getString("status");

                double amount =
                        MaintenanceCalculator.calculate(length, breadth, status);

                PreparedStatement pay =
                        con.prepareStatement(
                                "INSERT INTO payments(site_id,amount,pending,paid_date) VALUES(?,?,FALSE,NOW())"
                        );

                pay.setInt(1, siteId);
                pay.setDouble(2, amount);

                pay.executeUpdate();

                System.out.println("✅ Maintenance Collected: ₹" + amount);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ✅ Assign Site to Owner
    public static void assignSiteToOwner(int siteId, int ownerId, String siteType) {

        try (Connection con = dbConnection.getConnection()) {

            PreparedStatement ps =
                    con.prepareStatement(
                            "UPDATE sites SET owner_id=?, site_type=?, status='OCCUPIED' " +
                                    "WHERE site_id=? AND owner_id IS NULL"
                    );

            ps.setInt(1, ownerId);
            ps.setString(2, siteType);
            ps.setInt(3, siteId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ Site Assigned Successfully!");
            } else {
                System.out.println("❌ Site already assigned or invalid site ID!");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
