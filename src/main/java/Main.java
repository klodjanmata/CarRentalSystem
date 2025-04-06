import java.util.Scanner;

import Service.VehicleService;
import Util.Helper;

public class Main {
    private static VehicleService vehicleService = new VehicleService();
    public static void main(String[] args) {
        while(true) {
            Scanner scanner = new Scanner(System.in);
            printMenu();
            System.out.print("Choose an action (0 to exit): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("You selected: Vehicle Management.");
                    printVehicleManagmentMenu();
                    vehicleChoice(getChoice());
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
                    return;
                default:
                    System.out.println("Invalid choice. Please choose a number between 0 and 4.");
            }

        }

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
                "1- Vehicle Management \n" +
                "2- Client Management \n" +
                "3- Rental Transactions \n" +
                "4- Import/Export \n" +
                "0- Exit the Program");
    }

    public static void vehicleChoice(int choice) {
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
                break;
            default:
                System.out.println("Invalid choice. Please choose a number between 0 and 4.");
                break;
        }
    }

    public static int getChoice(){
        int choice = -1;
        try{
            choice = Helper.getIntFromUser();
        }catch (Exception e){
            choice = -1;
        }
        return choice;
    }

}



