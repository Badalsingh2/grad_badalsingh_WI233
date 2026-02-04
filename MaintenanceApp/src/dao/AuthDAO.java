package dao;

import Entity.Admin;
import Entity.SiteOwner;
import utils.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthDAO {

//    Register
    public boolean register(Admin admin){

        String sql = """
                insert into admin_table(
                admin_id,
                admin_name,
                email,
                password
                )values(?,?,?,?)
                """;

        try(Connection con = dbConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)){
            ps.setString(1,admin.getAdminId());
            ps.setString(2, admin.getAdminName());
            ps.setString(3,admin.getEmail());
            ps.setString(4, admin.getPassword());

            return ps.executeUpdate()>0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public boolean getAdminByEmailAndPassword(String email, String password){
        String sql = """
                select * from admin_table a where a.email = ? and a.password = ?
                """;

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

            }else{
                return false;
            }

            return true;


        } catch (SQLException e) {
            throw new RuntimeException("Failed to insert site", e);
        }
    }


    public List<SiteOwner> getAllSiteOwners(){
        String sql = """
                select * from site_owner order by owner_name;
                """;
        List<SiteOwner> owners = new ArrayList<>();
        try (Connection con = dbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                SiteOwner owner = new SiteOwner();

                owner.setOwnerId(rs.getString("owner_id"));
                owner.setOwnerName(rs.getString("owner_name"));
                owner.setPhoneNumber(rs.getLong("phone_number"));
                owner.setEmail(rs.getString("email"));
                owner.setPassword(rs.getString("password"));
                owner.setSiteNumber(
                        rs.getObject("site_number") != null
                                ? rs.getInt("site_number")
                                : null
                );

                owners.add(owner);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch site owners", e);
        }

        return owners;
    }

}
