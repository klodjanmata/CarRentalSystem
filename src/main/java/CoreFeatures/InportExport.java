package CoreFeatures;


import Entities.Rental;
import Entities.Client;
import Entities.Vehicle;
import Util.Helper;

import java.io.*;
import java.util.List;
import java.util.Scanner;

    public class InportExport {

        private Scanner scanner;

        public InportExport() {
            this.scanner = new Scanner(System.in);
        }

        public void exportRentalsToCSV(List<Rental> rentals) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("rental_transactions.csv"))) {
                writer.write("ID,Vehicle ID,Client ID,Rental Date,Return Date,Total Cost\n");
                for (Rental rental : rentals) {
                    writer.write(rental.getId() + "," +
                            rental.getVehicleId() + "," +
                            rental.getClientId() + "," +
                            rental.getRentalDate() + "," +
                            rental.getReturnDate() + "," +
                            rental.getTotalCost() + "\n");
                }
                System.out.println("Rental transactions exported successfully.");
            } catch (IOException e) {
                System.out.println("Error exporting rental transactions: " + e.getMessage());
            }
        }

        public void importVehiclesFromCSV(List<Vehicle> vehicles) {
            System.out.print("Enter the file path to import vehicles from CSV: ");
            String filePath = scanner.nextLine();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    Vehicle vehicle = new Vehicle();
                    vehicle.setId(Integer.parseInt(data[0]));
                    vehicle.setModel(data[1]);
                    vehicle.setMake(data[2]);
                    vehicle.setYear(Integer.parseInt(data[3]));
                    vehicle.setPricePerDay(Double.parseDouble(data[4]));
                    vehicles.add(vehicle);
                }
                System.out.println("Vehicles imported successfully.");
            } catch (IOException e) {
                System.out.println("Error importing vehicles: " + e.getMessage());
            }
        }

        public void importClientsFromCSV(List<Client> clients) {
            System.out.print("Enter the file path to import clients from CSV: ");
            String filePath = scanner.nextLine();
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    Client client = new Client();
                    client.setId(Integer.parseInt(data[0]));
                    client.setName(data[1]);
                    client.setSurname(data[2]);
                    client.setPhone(data[3]);
                    client.setEmail(data[4]);
                    clients.add(client);
                }
                System.out.println("Clients imported successfully.");
            } catch (IOException e) {
                System.out.println("Error importing clients: " + e.getMessage());
            }
        }
    }


