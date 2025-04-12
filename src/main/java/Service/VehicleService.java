package Service;

import Entities.Vehicle;
import Repository.VehicleRepository;
import Util.Helper;

public class VehicleService {
    private final VehicleRepository vehicleRepository = new VehicleRepository();

    public void addVehicle(){
        System.out.println("Creating new Vehicle");
        Vehicle v = new Vehicle();
        System.out.println("Enter make");
        v.setMake(Helper.getStringFromUser());
        System.out.println("Enter Model");
        v.setModel(Helper.getStringFromUser());
        System.out.println("Enter Year:");
        v.setYear(Helper.getIntFromUser());
        System.out.println("Enter License Plate:");
        v.setLicensePlate(Helper.getStringFromUser());
        System.out.println("Enter Daily rate:");
        v.setDailyRate(Helper.getFloatFromUser());
        System.out.println("Enter if is Available:");
        v.setAvailable(Helper.getBooleanFromUser());

        vehicleRepository.save(v);


    }

    public void updateVehicle(){
        System.out.print("Enter Licence Plate: ");
        String licensePlate = Helper.getStringFromUser();
        Vehicle v = vehicleRepository.getVehicleByRegistrationNumber(licensePlate);
        if(v == null){
            System.out.println("Vehicle not found");
            return;
        }
        System.out.println("Enter make");
        v.setMake(Helper.getStringFromUser());
        System.out.println("Enter Model");
        v.setModel(Helper.getStringFromUser());
        System.out.println("Enter Year:");
        v.setYear(Helper.getIntFromUser());
        System.out.println("Enter License Plate:");
        v.setLicensePlate(Helper.getStringFromUser());
        System.out.println("Enter Daily rate:");
        v.setDailyRate(Helper.getFloatFromUser());
        System.out.println("Enter if is Available:");
        v.setAvailable(Helper.getBooleanFromUser());

    }



}
