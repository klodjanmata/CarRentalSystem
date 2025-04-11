package Service;

import Entities.Client;
import Entities.Rental;
import Repository.ClientRepository;
import Repository.RentalRepository;
import Util.Helper;

public class RentalService {

    public void addRental() {
        System.out.println("Adding new Rental: ");
        Rental r = new Rental();
        System.out.println("Add Rental ID: ");
        r.setId(Helper.getIntFromUser());
        System.out.println("Add vehicle ID: ");
        r.setVehicleId(Helper.getIntFromUser());
        System.out.println("Add Clients ID: ");
        r.setClientId(Helper.getIntFromUser());
        System.out.println("Add rental date: ");
        r.setRentalDate(Helper.getDateFromUser());
        System.out.println("Add return date: ");
        r.setReturnDate(Helper.getDateFromUser());
        System.out.println("Add total cost: ");
        r.setTotalCost(Helper.getDoubleFromUser());


        RentalRepository.save(r);
    }
}
