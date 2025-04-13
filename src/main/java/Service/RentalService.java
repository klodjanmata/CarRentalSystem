package Service;

import Entities.Rental;
import Entities.Vehicle;
import Repository.ClientRepository;
import Repository.RentalRepository;
import Repository.VehicleRepository;
import Util.Helper;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RentalService {

    private static RentalRepository rentalRepository = new RentalRepository();
    private static VehicleRepository vehicleRepository = new VehicleRepository();
    private static ClientRepository clientRepository = new ClientRepository();

    public void addRental() {
        Rental r = new Rental();
        System.out.println("Add rental date: ");
        r.setRentalDate(Helper.getDateFromUser());
        System.out.println("Add return date: ");
        r.setReturnDate(Helper.getDateFromUser());
        System.out.println("Available vehicles: ");
        printVehicleList(findAvailableByDate(r.getRentalDate(), r.getReturnDate()));
        System.out.println("Add vehicle Licence Plate: ");
        r.setVehicle(vehicleRepository.getVehicleByRegistrationNumber(Helper.getStringFromUser()));
        System.out.println("Add Clients ID: ");
        r.setClient(clientRepository.getClientById(Helper.getIntFromUser()));

        r.setTotal(calculateTotalCost(r.getRentalDate(), r.getReturnDate(), r.getVehicle().getDailyRate()));
        System.out.println("Total Cost will be: " + r.getTotal() + " EUR");
        rentalRepository.save(r);
    }

    private double calculateTotalCost(LocalDate start, LocalDate end, double rate) {
        if (end.isBefore(start)) {
            throw new IllegalArgumentException("The end date cannot be before the start date.");
        }

        int days = 0;
        LocalDate current = start;

        while (!current.isEqual(end)) {
            days++;
            current = current.plusDays(1);
        }

        return days * rate;


}

    public void updateRental(){
        System.out.print("Enter Rental ID: ");
        int id = Helper.getIntFromUser();
        Rental r = rentalRepository.getRentalById(id);
        System.out.println("Add Rental ID: ");
        r.setId((long) Helper.getIntFromUser());
        System.out.println("Add vehicle Licence Plate: ");
        r.setVehicle(vehicleRepository.getVehicleByRegistrationNumber(Helper.getStringFromUser()));
        System.out.println("Add Clients ID: ");
        r.setClient(clientRepository.getClientById(Helper.getIntFromUser()));
        System.out.println("Add rental date: ");
        r.setRentalDate(Helper.getDateFromUser());
        System.out.println("Add return date: ");
        r.setReturnDate(Helper.getDateFromUser());
        r.setTotal(calculateTotalCost(r.getRentalDate(), r.getReturnDate(), r.getVehicle().getDailyRate()));

        rentalRepository.save(r);
    }

    public void deleteRental(){
        System.out.print("Enter Rental ID: ");
        int id = Helper.getIntFromUser();
        Rental r = rentalRepository.getRentalById(id);
        rentalRepository.delete(r);
        System.out.print("Deleted successfully");
    }

    public void findAllRentalTranscations(){
        System.out.println("View all Rental Transaction: ");
        List<Rental> rentals = rentalRepository.findAll();
        if (rentals.isEmpty()){
            System.out.println("No transactions available:");
        } else {
            for (Rental r : rentals){
                System.out.println(r);
            }

        }
    }

    public void returnRental(){
        System.out.print("Enter Rental ID: ");
        int id = Helper.getIntFromUser();
        Rental r = rentalRepository.getRentalById(id);
        r.setReturnDate(LocalDate.now());
        System.out.println("Customer should pay: " + r.getTotal() + " EUR");
        r.getVehicle().setAvailable(true);
    }

    public List<Vehicle> findAvailableByDate(LocalDate start, LocalDate end) {
        List<Vehicle> availableVehicles = new ArrayList<>();

        for (Vehicle vehicle : vehicleRepository.findAll()) {
            boolean taken = rentalRepository.findAll().stream()
                    .anyMatch(rental -> rental.getVehicle().equals(vehicle) &&
                            (start.isBefore(rental.getReturnDate()) && end.isAfter(rental.getRentalDate())));

            if (!taken) {
                availableVehicles.add(vehicle);
            }
        }

        return availableVehicles;
    }




    private void printVehicleList(List<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("There are no vehicles  to display");
            return;
        }

        for (Vehicle v : vehicles) {
            System.out.println(v.toString());
        }
    }

}


