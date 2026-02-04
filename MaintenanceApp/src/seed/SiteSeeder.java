// java
package seed;

import dao.SiteDAO;
import dto.SiteDTO;
import utils.SiteType;
import utils.OccupancyStatus;

public class SiteSeeder {

    private final SiteDAO siteDAO = new SiteDAO();

    public void seedSites(boolean force) {
        // If not forced, avoid re-seeding when sites already exist
        if (!force) {
            int existing = siteDAO.getAllSites().size();
            if (existing >= 35) return;
        }

        for (int i = 1; i <= 35; i++) {
            if (siteDAO.getSiteByNumber(i) != null && !force) continue;

            SiteDTO site = new SiteDTO();
            site.setSiteNumber(i);

            // sizes per specification
            if (i <= 10) {
                site.setLength(40);
                site.setBreadth(60);
            } else if (i <= 20) {
                site.setLength(30);
                site.setBreadth(50);
            } else {
                site.setLength(30);
                site.setBreadth(40);
            }

            // assign site type: every 7th is OPEN_SITE, others rotate among three types
            if (i % 7 == 0) {
                site.setSiteType(SiteType.OPEN_SITE);
            } else {
                int mod = i % 3;
                if (mod == 1) site.setSiteType(SiteType.VILLA);
                else if (mod == 2) site.setSiteType(SiteType.APARTMENT);
                else site.setSiteType(SiteType.INDEPENDENT_HOUSE);
            }

            // default occupancy: VACANT (admin can update)
            site.setOccupancyStatus(OccupancyStatus.VACANT);

            siteDAO.insertSite(site);
        }
    }
}
