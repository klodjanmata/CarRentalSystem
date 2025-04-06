package CoreFeatures;

import Entities.Rental;
import Util.Helper;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class RentalManagement {
    private List<Rental> rentals;
    private Scanner scanner;

    public RentalManagement() {
        this.rentals = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addRental() {
        Rental rental = new Rental();
        System.out.print("Enter Vehicle ID: ");
        rental.setVehicleId(Helper.getIntFromUser());
        System.out.print("Enter Client ID: ");
        rental.setClientId(Helper.getIntFromUser());
        System.out.print("Enter Rental Date (yyyy-mm-dd): ");
        rental.setRentalDate(Helper.getDateFromUser());
        System.out.print("Enter Return Date (yyyy-mm-dd): ");
        rental.setReturnDate(Helper.getDateFromUser());
        System.out.print("Enter Total Cost: ");
        rental.setTotalCost(Helper.getDoubleFromUser());
        rentals.add(rental);
        System.out.println("Rental added successfully.");
    }
}











