package Service;

import Entities.Rental;
import Repository.ClientRepository;
import Repository.RentalRepository;
import Repository.VehicleRepository;
import Util.Helper;

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
}
