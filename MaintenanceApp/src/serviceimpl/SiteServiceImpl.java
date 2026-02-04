package serviceimpl;

import dto.SiteDTO;
import services.SiteService;
import utils.MaintenanceStatus;
import utils.SiteType;

public class SiteServiceImpl implements SiteService {
    @Override
    public void addSite() {

    }

    @Override
    public void updateSite() {

    }

    @Override
    public void viewSite() {

    }

    private entity.Site mapDtoToEntity(SiteDTO dto) {
        entity.Site site = new entity.Site();
        site.setSiteNumber(dto.getSiteNumber());
        site.setLength(dto.getLength());
        site.setBreadth(dto.getBreadth());

        int sqft = dto.getLength() * dto.getBreadth();
        site.setSquareFeet(sqft);

        site.setSiteType(dto.getSiteType());
        site.setOccupancyStatus(dto.getOccupancyStatus());

        // maintenance calculated by rule
        int rate = (dto.getSiteType() == SiteType.OPEN_SITE) ? 6 : 9;
        site.setMaintenanceAmount(rate * sqft);
        site.setMaintenanceStatus(MaintenanceStatus.PENDING);

        return site;
    }
}
