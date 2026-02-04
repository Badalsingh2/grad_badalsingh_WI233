package dao;

import utils.dbConnection;

import java.sql.*;
import java.util.Scanner;

public class OwnerDAO {

    static Scanner sc = new Scanner(System.in);

    public static void registerOwner() {

        try (Connection con = dbConnection.getConnection()) {

            System.out.println("Enter Username:");
            String username = sc.next();

            System.out.println("Enter Password:");
            String password = sc.next();

            System.out.println("Enter Name:");
            String name = sc.next();

            System.out.println("Enter Phone:");
            String phone = sc.next();

            PreparedStatement ps =
                    con.prepareStatement(
                            "INSERT INTO owners(username,password,name,phone) VALUES(?,?,?,?)"
                    );

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, phone);

            ps.executeUpdate();
            System.out.println("✅ Owner Registered Successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int ownerLogin(String username, String password) {

        try (Connection con = dbConnection.getConnection()) {

            PreparedStatement ps =
                    con.prepareStatement(
                            "SELECT owner_id FROM owners WHERE username=? AND password=?"
                    );

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("owner_id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return -1;
    }
}
