package serviceimpl;

import dao.OwnerDAO;
import dao.PaymentDAO;
import dao.SiteDAO;
import services.AdminService;
import utils.AutoSiteGenerator;

import java.util.Scanner;

public class AdminServiceImpl implements AdminService {

    Scanner sc = new Scanner(System.in);

    public void adminMenu() {

        while (true) {

            System.out.println("\n===== ADMIN MENU =====");
            System.out.println("1. Register Owner");
            System.out.println("2. Auto Generate 35 Sites");
            System.out.println("3. Approve Owner Requests");
            System.out.println("4. Collect Maintenance");
            System.out.println("5. Assign Site to Owner");
            System.out.println("6. View Pending Payments Report");
            System.out.println("7. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    OwnerDAO.registerOwner();
                    break;

                case 2:
                    AutoSiteGenerator.generateSites();
                    break;

                case 3:
                    SiteDAO.approveOrRejectRequests();
                    break;

                case 4:
                    System.out.println("Enter Site ID:");
                    int siteId = sc.nextInt();

                    SiteDAO.collectMaintenance(siteId);
                    break;
                case 5:
                    System.out.println("Enter Site ID:");
                    int siteIdAssign = sc.nextInt();

                    System.out.println("Enter Owner ID:");
                    int ownerIdAssign = sc.nextInt();

                    System.out.println("Enter Site Type (Villa/Apartment/House):");
                    String siteType = sc.next();

                    SiteDAO.assignSiteToOwner(siteIdAssign, ownerIdAssign, siteType);
                    break;
                case 6:
                    PaymentDAO.viewPendingPayments();
                    break;

                case 7:
                    return;
            }
        }
    }
}
