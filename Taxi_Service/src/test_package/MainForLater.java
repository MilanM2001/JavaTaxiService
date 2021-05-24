package test_package;

public class MainForLater {

//    private static String Customers_File = "customersList.txt";
//    private static String Dispatchers_File = "dispatchersList.txt";
//    private static String Drivers_File = "driversList.txt";
//    private static String Cars_File = "carsList.txt";

}


//    public static void main(String[] args) {
//
//        TaxiService taxiService = new TaxiService();
//        taxiService.loadDrivers(Drivers_File);
//        taxiService.loadCustomers(Customers_File);
//        taxiService.loadDispatchers(Dispatchers_File);
//        taxiService.loadCars(Cars_File);
//
//        System.out.println("Content Loaded from Files:");
//        System.out.println("----------------------------------------------");
//        printContent(taxiService);
//        System.out.println("----------------------------------------------");
//
//        System.out.println("Adding Test Content...");
//
//        Customer testCustomer = new Customer("Milan2001", "milan123", "Milan", "Miljus", 012342, "Skolska14", 0652033, Gender.Male, false);
//        taxiService.addCustomer(testCustomer);
//
//        Dispatcher testDispatcher = new Dispatcher("Srdjan12", "srki123", "Srdjan", "Srdjanovic", 1234322222, "Dunavksa 12", 1234223231, Gender.Male, 40000, 1234231, Department.Reception, false);
//        taxiService.addDispatcher(testDispatcher);
//
//        Driver testDriver = new Driver("Zoki21", "zoran123", "Zoran", "Zoranovic", 12342121, "Vrsacka 2", 123421231, Gender.Male, 35000, 2112, false);
//        taxiService.addDriver(testDriver);
//
//        Car testCar = new Car("Audi", "Volkswagen", 2001, 4353, 8710542, VehicleType.Passenger, false);
//        taxiService.addCar(testCar);
//
//        System.out.println("Saving Added Content...");
//        taxiService.saveCustomers(Customers_File);
//        taxiService.saveDispatchers(Dispatchers_File);
//        taxiService.saveDrivers(Drivers_File);
//        taxiService.saveCars(Cars_File);
//
//
//    }
//
//
//    public static void printContent(TaxiService taxiService) {
//        for(Customer customer : taxiService.getCustomers()) {
//            System.out.println(customer + "\n");
//        }
//        for(Dispatcher dispatcher : taxiService.getDispatchers()) {
//            System.out.println(dispatcher + "\n");
//        }
//        for(Driver driver : taxiService.getDrivers()) {
//            System.out.println(driver + "\n");
//        }
//        for(Car car : taxiService.getCars()) {
//            System.out.println(car + "\n");
//        }
//    }


// if(username.equals("") || password.equals("")) {
//         JOptionPane.showMessageDialog(null, "You didn't fill all the required fields.", "Error", JOptionPane.WARNING_MESSAGE);
//         }else {
//         Customer customerLoggedIn = taxiService.customerLogin(username, password);
//         if(customerLoggedIn == null) {
//         JOptionPane.showMessageDialog(null, "Incorrect Login Information.", "Error", JOptionPane.WARNING_MESSAGE);
//         }else {
//         LoginWindow.this.dispose();
//         LoginWindow.this.setVisible(false);
//         CustomerMenu customerM = new CustomerMenu(taxiService, customerLoggedIn);
//         customerM.setVisible(true);
//         }
//         }