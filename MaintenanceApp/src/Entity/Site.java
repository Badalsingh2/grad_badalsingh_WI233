package entity;

import utils.SiteType;
import utils.OccupancyStatus;
import utils.MaintenanceStatus;

public class Site {

    private int siteId;
    private int siteNumber;
    private int length;
    private int breadth;
    private int squareFeet;
    private SiteType siteType;
    private OccupancyStatus occupancyStatus;
    private int maintenanceAmount;
    private MaintenanceStatus maintenanceStatus;

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public int getSiteNumber() {
        return siteNumber;
    }

    public void setSiteNumber(int siteNumber) {
        this.siteNumber = siteNumber;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBreadth() {
        return breadth;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }

    public int getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(int squareFeet) {
        this.squareFeet = squareFeet;
    }

    public SiteType getSiteType() {
        return siteType;
    }

    public void setSiteType(SiteType siteType) {
        this.siteType = siteType;
    }

    public OccupancyStatus getOccupancyStatus() {
        return occupancyStatus;
    }

    public void setOccupancyStatus(OccupancyStatus occupancyStatus) {
        this.occupancyStatus = occupancyStatus;
    }

    public int getMaintenanceAmount() {
        return maintenanceAmount;
    }

    public void setMaintenanceAmount(int maintenanceAmount) {
        this.maintenanceAmount = maintenanceAmount;
    }

    public MaintenanceStatus getMaintenanceStatus() {
        return maintenanceStatus;
    }

    public void setMaintenanceStatus(MaintenanceStatus maintenanceStatus) {
        this.maintenanceStatus = maintenanceStatus;
    }
}
