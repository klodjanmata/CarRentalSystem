import CoreFeatures.VehicleManagement;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        System.out.print("Choose an action (0 to exit): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("You selected: Add Vehicle Management.");
                printVehicleManagmentMenu();
                break;
            case 2:
                System.out.println("You selected: Add Client Management.");
                break;
            case 3:
                System.out.println("You selected: Add Rental Transactions.");
                break;
            case 4:
                System.out.println("You selected: Add Import/Export.");
                break;
            case 0:
                System.out.println("Exiting the program...");
                break;
            default:
                System.out.println("Invalid choice. Please choose a number between 0 and 4.");
        }

        scanner.close();
    }

    public static void VehicleManagmentMenu() {
        Scanner scanner = new Scanner(System.in);
        printVehicleManagmentMenu();
        System.out.println("Choose an action (0 to exit)");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("You selected: Add Vehicle Management.");
                printVehicleManagmentMenu();

                break;
            case 2:
                System.out.println("You selected: Add Vehicle.");
                break;
            case 3:
                System.out.println("You selected: Update Vehicle.");
                break;
            case 4:
                System.out.println("You selected: Delete Vehicle.");
                break;
            case 5:
                System.out.println("You selected: View Vehicle Inventory.");
                break;
            case 0:
                System.out.println("Back to main menu...");
                break;
            default:
                System.out.println("Invalid choice. Please choose a number between 0 and 4.");
        }
        scanner.close();
    }
    public static void printVehicleManagmentMenu(){
        System.out.println("Choose an action: \n" +
                "1- Add Vehicle \n" +
                "2- Update Vehicle \n" +
                "3- Delete Vehicle \n" +
                "4- View Vehicle Inventory \n" +
                "0- Back to main menu");

    }


    public static void printMenu() {
        System.out.println("Choose an action: \n" +
                "1- Add Vehicle Management \n" +
                "2- Add Client Management \n" +
                "3- Add Rental Transactions \n" +
                "4- Add Import/Export \n" +
                "0- Exit the Program");
    }
}



