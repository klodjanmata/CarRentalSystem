package Service;

import Entities.Vehicle;
import Repository.VehicleRepository;
import Util.Helper;

public class VehicleService {
    private final VehicleRepository vehicleRepository = new VehicleRepository();
    public void addVehicle(){
        System.out.println("Creating new Vehicle!");
        Vehicle v = new Vehicle();
        System.out.print("Enter License Plate: ");
        v.setLicensePlate(Helper.getStringFromUser());



        vehicleRepository.save(v);

    }
}
