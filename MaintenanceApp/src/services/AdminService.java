package services;

public interface AdminService {
    void addSite();
    void editSite();
    void removeSite();

    void collectMaintenance();
    void viewPendingMaintenance();

    void approveOwnerUpdate();
    void rejectOwnerUpdate();
}
