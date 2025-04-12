import java.util.Scanner;

import Service.VehicleService;
import Service.ClientService;
import Service.RentalService;
import Util.Helper;

public class Main {
    private static VehicleService vehicleService = new VehicleService();
    private static ClientService clientService = new ClientService();
    private static RentalService rentalService = new RentalService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while(true) {
            printMenu();
            System.out.print("Choose an action (0 to exit): ");
            int choice = getChoice();

            switch (choice) {
                case 1:
                    System.out.println("You selected: Vehicle Management.");
                    vehicleChoice();
                    break;
                case 2:
                    System.out.println("You selected: Client Management.");
                    clientChoice();
                    break;
                case 3:
                    System.out.println("You selected: Rental Transactions.");
                    rentalChoice();
                    break;
                case 4:
                    System.out.println("You selected: Import/Export.");
                    importExportChoice();
                    break;
                case 0:
                    System.out.println("Exiting the program...");

                    return;
                default:
                    System.out.println("Invalid choice. Please choose a number between 0 and 4.");
            }
        }
    }

    public static void printVehicleManagmentMenu() {
        System.out.println("Choose an action: \n" +
                "1- Add Vehicle \n" +
                "2- Update Vehicle \n" +
                "3- Delete Vehicle \n" +
                "4- View Vehicle Inventory \n" +
                "0- Back to main menu");
    }

    public static void printClientManagementMenu() {
        System.out.println("Choose an action: \n" +
                "1- Add Client \n" +
                "2- Update Client \n" +
                "3- Delete Client \n" +
                "4- View Client List \n" +
                "0- Back to main menu");
    }

    public static void printRentalManagementMenu() {
        System.out.println("Choose an action: \n" +
                "1- Add Rental \n" +
                "2- Update Rental \n" +
                "3- Delete Rental \n" +
                "4- View Rental Transactions \n" +
                "0- Back to main menu");
    }

    public static void printImportExportMenu() {
        System.out.println("Choose an action: \n" +
                "1- Import Data \n" +
                "2- Export Data \n" +
                "0- Back to main menu");
    }

    public static void printMenu() {
        System.out.println("Choose an action: \n" +
                "1- Vehicle Management \n" +
                "2- Client Management \n" +
                "3- Rental Transactions \n" +
                "4- Import/Export \n" +
                "0- Exit the Program");
    }

    public static void vehicleChoice() {
        System.out.println();
        int choice = -1;
        printVehicleManagmentMenu();
        while (choice != 0) {
            choice = getChoice();
            switch (choice) {
                case 1:
                    vehicleService.addVehicle();
                    break;
                case 2:
                    System.out.println("Update Vehicle");
                    break;
                case 3:
                    System.out.println("Delete Vehicle");
                    break;
                case 4:
                    System.out.println("View Vehicle Inventory");
                    break;
                case 0:
                    System.out.println("Back to main menu");
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a number between 0 and 4.");
                    break;
            }
        }
    }

    public static void clientChoice() {
        int choice = -1;
        while (choice != 0) {
            printClientManagementMenu();
            Scanner scanner = new Scanner(System.in);
            choice = getChoice();
            switch (choice) {
                case 1:
                    clientService.addClient();
                    break;
                case 2:
                    System.out.println("Update Client");
                    break;
                case 3:
                    System.out.println("Delete Client");
                    break;
                case 4:
                    System.out.println("View Client List");
                    break;
                case 0:
                    System.out.println("Back to main menu");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a number between 0 and 4.");
                    break;
            }
        }
    }

    public static void rentalChoice() {
        int choice = -1;
        while (choice != 0) {
            printRentalManagementMenu();
            Scanner scanner = new Scanner(System.in);
            choice = getChoice();
            switch (choice) {
                case 1:
                    System.out.println("Add Rental");
                    break;
                case 2:
                    System.out.println("Update Rental");
                    break;
                case 3:
                    System.out.println("Delete Rental");
                    break;
                case 4:
                    System.out.println("View Rental Transactions");
                    break;
                case 0:
                    System.out.println("Back to main menu");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a number between 0 and 4.");
                    break;
            }
        }
    }

    public static void importExportChoice() {
        int choice = -1;
        while (choice != 0) {
            printImportExportMenu();
            Scanner scanner = new Scanner(System.in);
            choice = getChoice();
            switch (choice) {
                case 1:
                    System.out.println("Importing Data...");
                    break;
                case 2:
                    System.out.println("Exporting Data...");
                    break;
                case 0:
                    System.out.println("Back to main menu");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a number between 0 and 2.");
                    break;
            }
        }
    }

    public static int getChoice() {
        int choice = -1;
        while (choice == -1) {
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
        return choice;
    }
}
