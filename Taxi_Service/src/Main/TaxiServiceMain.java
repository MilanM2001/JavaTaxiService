package Main;


import GUI.LoginWindow;
import ServiceData.TaxiService;

public class TaxiServiceMain {

    public static String Customers_File = "customersList.txt";
    public static String Dispatchers_File = "dispatchersList.txt";
    public static String Drivers_File = "driversList.txt";
    public static String Cars_File = "carsList.txt";
    public static String Rides_File = "ridesList.txt";
    public static String Info_File = "taxiServiceInfo.txt";

    public static void main(String[] args) {
        TaxiService taxiService = new TaxiService();
        taxiService.loadDrivers(Drivers_File);
        taxiService.loadCustomers(Customers_File);
        taxiService.loadDispatchers(Dispatchers_File);
        taxiService.loadCars(Cars_File);
        taxiService.loadRides(Rides_File);
        taxiService.loadInfo(Info_File);

        LoginWindow lw = new LoginWindow(taxiService);
        lw.setVisible(true);
    }


}
