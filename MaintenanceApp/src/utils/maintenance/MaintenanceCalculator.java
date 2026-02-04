// java
package utils.maintenance;

import dto.SiteDTO;
import utils.SiteType;
import utils.OccupancyStatus;

public class MaintenanceCalculator {

    // returns maintenance charge in Rs for the site (area in sqft * rate)
    public static double calculate(SiteDTO site) {
        int length = site.getLength();
        int breadth = site.getBreadth();
        double area = (double) length * breadth;

        double rate;

        // rule: OPEN_SITE type -> 6, OCCUPIED status -> 9, default -> 6
        if (site.getSiteType() == SiteType.OPEN_SITE) {
            rate = 6.0;
        } else if (site.getOccupancyStatus() == OccupancyStatus.OCCUPIED) {
            rate = 9.0;
        } else {
            rate = 6.0;
        }

        return area * rate;
    }
}
