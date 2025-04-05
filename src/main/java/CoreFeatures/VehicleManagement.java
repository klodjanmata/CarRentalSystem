package CoreFeatures;


    import Entities.Vehicle;

    import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class VehicleManagement {
        private List<Vehicle> vehicles;
        private Scanner scanner;

        public VehicleManagement() {
            vehicles = new ArrayList<>();
            scanner = new Scanner(System.in);
        }
     
        public void addVehicle() {
            System.out.print("Make: ");
            String make = scanner.nextLine();
            System.out.print("Model: ");
            String model = scanner.nextLine();
            System.out.print("Year: ");
            int year = scanner.nextInt();
            scanner.nextLine();
            System.out.print("License Plate: ");
            String plate = scanner.nextLine();
            System.out.print("Daily Rate: ");
            double rate = scanner.nextDouble();
            scanner.nextLine();

            Vehicle v = new Vehicle(vehicles.size() + 1, make, model, year, plate, rate, true);
            vehicles.add(v);
            System.out.println("Vehicle added successfully.");
        }


    }
