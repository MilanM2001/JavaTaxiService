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

        System.out.println("Printed Content from Files:");
        System.out.println("----------------------------------------------");
        printContent(taxiService);
        System.out.println("----------------------------------------------");

        Driver testDriver = new Driver("Milan01", "milan2001", "Milan", "Miljus", 23123232, "Skolska14", 2312412, Gender.Male);
        taxiService.addDriver(testDriver);

        Car testCar = new Car("Audi", "Volkswagen Group", 2004, 1234, 06520445, VehicleType.Van);
        taxiService.addCar(testCar);

        System.out.println("Saving content...");
        taxiService.saveDrivers(Drivers_File);
        taxiService.saveCars(Vehicles_File);



    }

    public static void printContent(TaxiService taxiService) {

        for(Driver driver : taxiService.getDrivers()) {
            System.out.println(driver + "\n");
        }

        for(Car car : taxiService.getCars()) {
            System.out.println(car + "\n");
        }

    }





}
