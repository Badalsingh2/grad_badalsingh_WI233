import dao.OwnerDAO;
import serviceimpl.AdminServiceImpl;
import serviceimpl.OwnerServiceImpl;
import services.AdminService;
import services.OwnerService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Layout Maintenance Application =====");
            System.out.println("1. Admin Login");
            System.out.println("2. Owner Login");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            if (choice == 1) {
                AdminService admin = new AdminServiceImpl();
                admin.adminMenu();
            }

            else if (choice == 2) {

                System.out.println("Enter Username:");
                String username = sc.next();

                System.out.println("Enter Password:");
                String password = sc.next();

                int ownerId = OwnerDAO.ownerLogin(username, password);

                if (ownerId != -1) {
                    OwnerService owner = new OwnerServiceImpl();
                    owner.ownerMenu(ownerId);
                }
                else {
                    System.out.println("❌ Invalid Login!");
                }
            }

            else {
                System.exit(0);
            }
        }
    }
}
