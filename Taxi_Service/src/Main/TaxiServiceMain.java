package Main;


import GUI.LoginWindow;

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

        LoginWindow lw = new LoginWindow();
        lw.setVisible(true);

    }


}
