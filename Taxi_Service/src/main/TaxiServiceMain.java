package main;


import allUsers.Driver;
import allUsers.Gender;
import cars.Car;
import cars.VehicleType;

public class TaxiServiceMain {

    private static String Drivers_File = "driversList.txt";
    private static String Vehicles_File = "carsList.txt";

    public static void main(String[] args) {

        TaxiService taxiService = new TaxiService();

        taxiService.loadDrivers(Drivers_File);
        taxiService.loadVehicles(Vehicles_File);

        System.out.println("Saving content...");
        taxiService.saveDrivers(Drivers_File);
        taxiService.saveCars(Vehicles_File);



    }




}
