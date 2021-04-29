package main;


import allUsers.Driver;
import allUsers.Gender;

public class TaxiServiceMain {

    private static String Drivers_File = "driversList.txt";

    public static void main(String[] args) {

        TaxiService taxiService = new TaxiService();

        taxiService.loadDrivers(Drivers_File);

        System.out.println("Printed Content from Files:");
        System.out.println("----------------------------------------------");
        printContent(taxiService);
        System.out.println("----------------------------------------------");

        Driver testDriver = new Driver("Milan01", "milan2001", "Milan", "Miljus", 23123232, "Skolska14", 2312412, Gender.Male);
        taxiService.addDriver(testDriver);

        System.out.println("Saving content...");
        taxiService.saveDrivers(Drivers_File);



    }

    public static void printContent(TaxiService taxiService) {

        for(Driver driver : taxiService.getDrivers()) {
            System.out.println(driver + "\n");
        }

    }





}
