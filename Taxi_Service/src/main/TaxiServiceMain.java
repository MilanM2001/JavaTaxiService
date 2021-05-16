package main;


import allUsers.Customer;
import allUsers.Dispatcher;
import allUsers.Driver;
import cars.Car;
import enums.Department;
import enums.Gender;
import enums.VehicleType;
import gui.LoginWindow;

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

        LoginWindow lw = new LoginWindow(taxiService);
        lw.setVisible(true);

    }


}
