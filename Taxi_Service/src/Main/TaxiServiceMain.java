package Main;


import ServiceData.TaxiService;

public class TaxiServiceMain {

    public static String Customers_File = "customersList.txt";
    public static String Dispatchers_File = "dispatchersList.txt";
    public static String Drivers_File = "driversList.txt";
    public static String Cars_File = "carsList.txt";
    public static String Rides_File = "ridesList.txt";
    public static String Info_File = "taxiServiceInfo.txt";
    public static String YearlyStatistics_File = "yearlyStatistics.txt";
    public static String MonthlyStatistics_File = "monthlyStatistics.txt";
    public static String WeeklyStatistics_File = "weeklyStatistics.txt";
    public static String DailyStatistics_File = "dailyStatistics.txt";
    public static String Offers_File = "offersList.txt";

    public static void main(String[] args) {
        TaxiService taxiService = new TaxiService();
        taxiService.loadDrivers(Drivers_File);
        taxiService.loadCustomers(Customers_File);
        taxiService.loadDispatchers(Dispatchers_File);
        taxiService.loadCars(Cars_File);
        taxiService.loadRides(Rides_File);
        taxiService.loadInfo(Info_File);
        taxiService.loadStatistics(YearlyStatistics_File);
        taxiService.loadStatistics(MonthlyStatistics_File);
        taxiService.loadStatistics(WeeklyStatistics_File);
        taxiService.loadStatistics(DailyStatistics_File);
        taxiService.loadOffers(Offers_File);

        LoginWindow lw = new LoginWindow(taxiService);
        lw.setVisible(true);
    }

}