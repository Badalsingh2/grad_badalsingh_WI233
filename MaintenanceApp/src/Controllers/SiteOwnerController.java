package Controllers;

import Entity.SiteOwner;
import dao.SiteDAO;
import dao.SiteOwnerDAO;
import dto.SiteDTO;

public class SiteOwnerController {
    SiteOwnerDAO siteOwnerDAO = new SiteOwnerDAO();
    SiteDAO siteDAO = new SiteDAO();
    SiteOwner siteOwner = null;
    public boolean register(SiteOwner siteOwner){
        return siteOwnerDAO.insertData(siteOwner);

    }

    public boolean login(String email,String password){
        siteOwner = siteOwnerDAO.getOwnerByEmailAndPassword(email,password);
        return siteOwner!=null;
    }

    public SiteDTO getAllSiteByOwner(){
        return siteDAO.getSiteByNumber(siteOwner.getSiteNumber());
    }


}
