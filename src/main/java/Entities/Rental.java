package Entities;

import java.time.LocalDate;

public class Rental {
    int id;
    int vehicleId;
    int clientId;
    LocalDate rentalDate;
    LocalDate returnDate;
    double totalCost;

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public LocalDate getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(LocalDate rentalDate) {
        this.rentalDate = rentalDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    Rental(int id, int vehicleId, int clientId, LocalDate rentalDate, LocalDate returnDate, double totalCost) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.clientId = clientId;
        this.rentalDate = rentalDate;
        this.returnDate = returnDate;
        this.totalCost = totalCost;
    }
   @Override
    public String toString() {
        return id + ": Client ID " + clientId + ", Vehicle ID " + vehicleId + ", From " + rentalDate + " to " + returnDate + ", Cost: $" + totalCost;
    }

}
