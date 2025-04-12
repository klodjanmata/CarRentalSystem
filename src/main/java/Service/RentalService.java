package Service;

import Entities.Rental;
import Repository.ClientRepository;
import Repository.RentalRepository;
import Repository.VehicleRepository;
import Util.Helper;

import java.util.List;

public class RentalService {

    private static RentalRepository rentalRepository = new RentalRepository();
    private static VehicleRepository vehicleRepository = new VehicleRepository();
    private static ClientRepository clientRepository = new ClientRepository();

    public void addRental() {
        System.out.println("Adding new Rental: ");
        Rental r = new Rental();
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
        System.out.println("Add total cost: ");
        r.setTotal(Helper.getDoubleFromUser());
        rentalRepository.save(r);
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
        System.out.println("Add total cost: ");
        r.setTotal(Helper.getDoubleFromUser());
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
}
