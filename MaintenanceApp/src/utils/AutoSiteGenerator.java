package utils;

import dao.SiteDAO;

public class AutoSiteGenerator {

    public static void generateSites() {

        int siteNumber = 1;

        // First 10 sites: 40×60
        for (int i = 1; i <= 10; i++) {
            SiteDAO.insertSite(siteNumber++, 40, 60);
        }

        // Next 10 sites: 30×50
        for (int i = 1; i <= 10; i++) {
            SiteDAO.insertSite(siteNumber++, 30, 50);
        }

        // Last 15 sites: 30×40
        for (int i = 1; i <= 15; i++) {
            SiteDAO.insertSite(siteNumber++, 30, 40);
        }

        System.out.println("✅ 35 Sites Generated Successfully!");
    }
}
