package main;


import allUsers.Customer;
import allUsers.Dispatcher;
import allUsers.Driver;
import cars.Car;
import enums.Gender;

public class TaxiServiceMain {

    private static String Customers_File = "customersList.txt";
    private static String Dispatchers_File = "dispatchersList.txt";
    private static String Drivers_File = "driversList.txt";
    private static String Cars_File = "carsList.txt";

    public static void main(String[] args) {

        TaxiService taxiService = new TaxiService();
        taxiService.loadDrivers(Drivers_File);
        taxiService.loadCustomers(Customers_File);
        taxiService.loadDispatchers(Dispatchers_File);
        taxiService.loadCars(Cars_File);

        System.out.println("Content Loaded from Files:");
        System.out.println("----------------------------------------------");
        printContent(taxiService);
        System.out.println("----------------------------------------------");

        System.out.println("Adding Test Content...");
        Customer testCustomer = new Customer("Milan2001", "milan123", "Milan", "Miljus", 012342, "Skolska14", 0652033, Gender.Male, false);
        taxiService.addCustomer(testCustomer);



        System.out.println("Saving Added Content...");
        taxiService.saveCustomers(Customers_File);



    }


    public static void printContent(TaxiService taxiService) {
        for(Customer customer : taxiService.getCustomers()) {
            System.out.println(customer + "\n");
        }

        for(Dispatcher dispatcher : taxiService.getDispatchers()) {
            System.out.println(dispatcher + "\n");
        }
        for(Driver driver : taxiService.getDrivers()) {
            System.out.println(driver + "\n");
        }
        for(Car car : taxiService.getCars()) {
            System.out.println(car + "\n");
        }
    }


}
