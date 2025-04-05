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

    public static void printVehicleManagmentMenu(){


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
