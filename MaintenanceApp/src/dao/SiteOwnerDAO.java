package dao;

import Entity.SiteOwner;
import utils.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SiteOwnerDAO {
    public boolean insertData(SiteOwner siteOwner){
        String sql = """
            INSERT INTO site_owner (
                owner_id,
                owner_name,
                phone_number,
                email,
                password            
            ) VALUES (?, ?, ?, ?, ?)
        """;
        try (Connection con = dbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, siteOwner.getOwnerId());
            ps.setString(2, siteOwner.getOwnerName());
            ps.setLong(3, siteOwner.getPhoneNumber());
            ps.setString(4, siteOwner.getEmail());
            ps.setString(5, siteOwner.getPassword());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Failed to insert site", e);
        }
    }

    public SiteOwner getOwnerByEmailAndPassword(String email,String password){
        String sql = """
                select * from site_owner s where s.email = ? and s.password = ?
                """;
        SiteOwner siteOwner = null;
        try(Connection con = dbConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1,email);
            ps.setString(2,password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                System.out.println("Owner Details is:");
                System.out.println();
                System.out.println(rs.getString("owner_id"));
                System.out.println(rs.getString("owner_name"));
                System.out.println(rs.getLong("phone_number"));
                System.out.println(rs.getString("email"));
                System.out.println(rs.getString("password"));
                SiteOwner siteOwner1 = new SiteOwner();
                siteOwner1.setSiteNumber(
                        rs.getObject("site_number") != null
                                ? rs.getInt("site_number")
                                : null
                );
                siteOwner1.setOwnerId(rs.getString("owner_id"));
                siteOwner1.setOwnerName(rs.getString("owner_name"));
                siteOwner1.setPassword(rs.getString("password"));
                siteOwner1.getEmail();
                siteOwner1.setPassword(String.valueOf(rs.getLong("phone_number")));
                siteOwner = siteOwner1;

            }

            return siteOwner;


        } catch (SQLException e) {
            throw new RuntimeException("Failed to insert site", e);
        }
    }
}
