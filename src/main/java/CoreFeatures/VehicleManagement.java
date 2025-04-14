package CoreFeatures;


    import Entities.Vehicle;
    import lombok.Getter;
    import lombok.Setter;

    import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

    public class VehicleManagement {
        @Setter
        private List<VehicleManagement> vehicles;
        @Getter
        private Scanner scanner;
        private Vehicle getVehicleById;

        public VehicleManagement() {
            vehicles = new ArrayList<>();
            scanner = new Scanner(System.in);
        }

        public VehicleManagement(int i, String make, String model, int year, String plate, double rate, boolean b) {
        }

        public void addVehicle(Vehicle vehicle2) {
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

            VehicleManagement v = new VehicleManagement(vehicles.size() + 1, make, model, year, plate, rate, true);
            vehicles.add(v);
            System.out.println("Vehicle added successfully.");
        }


        public Vehicle[] getVehicles() {
            Vehicle[] Vehicle = new Vehicle[0];
            return Vehicle;
        }

        public void setScanner(Scanner scanner) {
            this.scanner = scanner;
        }

        public Vehicle getVehicleById(Object vehicleId) {
            this.getVehicleById = getVehicleById;{
            }
            return getVehicleById;
            }

        }








