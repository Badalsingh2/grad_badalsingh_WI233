package serviceimpl;

import dao.SiteDAO;

import java.util.Scanner;

public class OwnerServiceImpl implements services.OwnerService {

    Scanner sc = new Scanner(System.in);


    public void ownerMenu(int ownerId) {

        while (true) {

            System.out.println("\n===== OWNER MENU =====");
            System.out.println("1. View My Site");
            System.out.println("2. Request Status Update");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    SiteDAO.viewOwnerSite(ownerId);
                    break;

                case 2:
                    System.out.println("Enter Site ID:");
                    int siteId = sc.nextInt();

                    System.out.println("Enter New Status (OPEN/OCCUPIED):");
                    String status = sc.next();

                    SiteDAO.requestSiteUpdate(siteId, status);
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
