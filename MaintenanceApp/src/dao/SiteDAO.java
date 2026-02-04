package dao;

import dto.SiteDTO;
import utils.OccupancyStatus;
import utils.SiteType;
import utils.dbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SiteDAO {

    // 1️⃣ INSERT SITE
    public boolean insertSite(SiteDTO site) {
        String sql = """
            INSERT INTO site (
                site_number,
                length,
                breadth,
                site_type,
                occupancy_status
            ) VALUES (?, ?, ?, ?, ?)
        """;

        try (Connection con = dbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, site.getSiteNumber());
            ps.setInt(2, site.getLength());
            ps.setInt(3, site.getBreadth());
            ps.setString(4, site.getSiteType().name());
            ps.setString(5, site.getOccupancyStatus().name());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Failed to insert site", e);
        }
    }

    // 2️⃣ GET SITE BY NUMBER
    public SiteDTO getSiteByNumber(int siteNumber) {
        String sql = "SELECT * FROM site WHERE site_number = ?";

        try (Connection con = dbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, siteNumber);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return mapToSiteDTO(rs);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch site", e);
        }
        return null;
    }

    // 3️⃣ GET ALL SITES
    public List<SiteDTO> getAllSites() {
        String sql = "SELECT * FROM site ORDER BY site_number";
        List<SiteDTO> sites = new ArrayList<>();

        try (Connection con = dbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                sites.add(mapToSiteDTO(rs));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to fetch all sites", e);
        }
        return sites;
    }

    // 4️⃣ UPDATE SITE (ADMIN / OWNER REQUEST)
    public boolean updateSite(SiteDTO site) {
        String sql = """
            UPDATE site
            SET length = ?,
                breadth = ?,
                site_type = ?,
                occupancy_status = ?
            WHERE site_number = ?
        """;

        try (Connection con = dbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, site.getLength());
            ps.setInt(2, site.getBreadth());
            ps.setString(3, site.getSiteType().name());
            ps.setString(4, site.getOccupancyStatus().name());
            ps.setInt(5, site.getSiteNumber());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Failed to update site", e);
        }
    }

    // 5️⃣ DELETE SITE
    public boolean deleteSite(int siteNumber) {
        String sql = "DELETE FROM site WHERE site_number = ?";

        try (Connection con = dbConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, siteNumber);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException("Failed to delete site", e);
        }
    }

    // 🔁 ResultSet → DTO mapper
    private SiteDTO mapToSiteDTO(ResultSet rs) throws SQLException {
        SiteDTO site = new SiteDTO();

        site.setSiteNumber(rs.getInt("site_number"));
        site.setLength(rs.getInt("length"));
        site.setBreadth(rs.getInt("breadth"));
        site.setSiteType(SiteType.valueOf(rs.getString("site_type")));
        site.setOccupancyStatus(
                OccupancyStatus.valueOf(rs.getString("occupancy_status"))
        );

        return site;
    }
}
