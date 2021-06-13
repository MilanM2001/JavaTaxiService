package ServiceData;

import AllUsers.Customer;
import AllUsers.Dispatcher;
import AllUsers.Driver;
import AllUsers.Users;
import Enums.*;
import Cars.Car;
import Rides.Ride;

import java.io.*;
import java.util.ArrayList;

public class TaxiService {

    private ArrayList<Driver> drivers;
    private ArrayList<Customer> customers;
    private ArrayList<Dispatcher> dispatchers;
    private ArrayList<Car> cars;
    private ArrayList<Ride> rides;
    private ArrayList<TaxiServiceInfo> serviceInfos;

    public TaxiService() {
        this.drivers = new ArrayList<Driver>();
        this.customers = new ArrayList<Customer>();
        this.dispatchers = new ArrayList<Dispatcher>();
        this.cars = new ArrayList<Car>();
        this.rides = new ArrayList<Ride>();
        this.serviceInfos = new ArrayList<TaxiServiceInfo>();
    }

    public ArrayList<Driver> getDrivers() {return drivers;}
    public void addDriver(Driver driver) {this.drivers.add(driver); }
    public void removeDriver(Driver driver) {this.drivers.remove(driver);}

    public ArrayList<Customer> getCustomers() {return customers;}
    public void addCustomer(Customer customer) {this.customers.add(customer); }
    public void removeCustomer(Customer customer) {this.customers.remove(customer);}

    public ArrayList<Dispatcher> getDispatchers() {return dispatchers;}
    public void addDispatcher(Dispatcher dispatcher) { this.dispatchers.add(dispatcher); }
    public void removeDispatcher(Dispatcher dispatcher) {this.dispatchers.remove(dispatcher);}

    public ArrayList<Car> getCars() {return cars;}
    public void addCar(Car car) {this.cars.add(car);}
    public void removeCar(Car car) {this.cars.remove(car);}

    public ArrayList<Ride> getRides() {return rides;}
    public void addRide(Ride ride) { this.rides.add(ride); }
    public void removeRide(Ride ride) {this.rides.remove(ride);}

    public ArrayList<TaxiServiceInfo> getServiceInfos() {return serviceInfos;}
    public void addInfo(TaxiServiceInfo taxiServiceInfo) { this.serviceInfos.add(taxiServiceInfo); }
    public void removeInfo(TaxiServiceInfo taxiServiceInfo) {this.serviceInfos.remove(taxiServiceInfo);}

    public Driver driverLogin(String username, String password) {
        for(Driver driver : drivers) {
            if(driver.getUsername().equalsIgnoreCase(username) &&
                    driver.getPassword().equals(password) && !driver.isDeleted()) {
                return driver;
            }
        }
        return null;
    }

    public Customer customerLogin(String username, String password) {
        for(Customer customer : customers) {
            if(customer.getUsername().equalsIgnoreCase(username) &&
                    customer.getPassword().equals(password) && !customer.isDeleted()) {
                return customer;
            }
        }
        return null;
    }
//
//    public Users usersLogin(String username, String password) {
//        for(Users users : customers) {
//            if(customer.getUsername().equalsIgnoreCase(username) &&
//                    customer.getPassword().equals(password) && !customer.isDeleted()) {
//                return customer;
//            }
//        }
//        return null;
//    }

    public Dispatcher dispatcherLogin(String username, String password) {
        for(Dispatcher dispatcher : dispatchers) {
            if(dispatcher.getUsername().equalsIgnoreCase(username) &&
                    dispatcher.getPassword().equals(password) && !dispatcher.isDeleted()) {
                return dispatcher;
            }
        }
        return null;
    }

    public Dispatcher findDispatcher(String username) {
        for (Dispatcher dispatcher : dispatchers) {
            if (dispatcher.getUsername().equals(username)) {
                return dispatcher;
            }
        }
        return null;
    }

    public Customer findCustomer(String username) {
        for (Customer customer : customers) {
            if (customer.getUsername().equals(username)) {
                return customer;
            }
        }
        return null;
    }

    public Driver findDriver(String username) {
        for (Driver driver : drivers) {
            if (driver.getUsername().equals(username)) {
                return driver;
            }
        }
        return null;
    }

    public Car findCar(String IDCode) {
        for (Car car : cars) {
            if (car.getIDCode().equals(IDCode)) {
                return car;
            }
        }
        return null;
    }

    public Ride findRide(String rideID) {
        for (Ride ride : rides) {
            if (ride.getRideID().equals(rideID)) {
                return ride;
            }
        }
        return null;
    }

    public TaxiServiceInfo findInfo(String TaxiServiceName) {
        for (TaxiServiceInfo taxiServiceInfo : serviceInfos) {
            if (taxiServiceInfo.getTaxiServiceName().equals(TaxiServiceName)) {
                return taxiServiceInfo;
            }
        }
        return null;
    }

    public void loadDispatchers(String fileName) {
        try {
            File usersFile = new File("src/txtFiles/" + fileName);
            BufferedReader br = new BufferedReader(new FileReader(usersFile));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] split = line.split("\\|");
                String username = split[0];
                String password = split[1];
                String name = split[2];
                String lastName = split[3];
                String jmbg = split[4];
                String address = split[5];
                int phoneNumber = Integer.parseInt(split[6]);
                int genderInt = Integer.parseInt(split[7]);
                Gender gender = Gender.values()[genderInt];
                boolean deleted = Boolean.parseBoolean(split[8]);
                int id = Integer.parseInt(split[9]);
                int rolesInt = Integer.parseInt(split[10]);
                Roles roles = Roles.values()[rolesInt];
                double dispatcherPay = Double.parseDouble(split[11]);
                int phoneLine = Integer.parseInt(split[12]);
                int departmentInt = Integer.parseInt(split[13]);
                Department department = Department.values()[departmentInt];

                Dispatcher dispatcher = new Dispatcher(username, password, name, lastName, jmbg, address, phoneNumber, gender, deleted, id, roles, dispatcherPay, phoneLine, department);
                dispatchers.add(dispatcher);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadCustomers(String fileName) {
        try {
            File usersFile = new File("src/txtFiles/" + fileName);
            BufferedReader br = new BufferedReader(new FileReader(usersFile));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] split = line.split("\\|");
                String username = split[0];
                String password = split[1];
                String name = split[2];
                String lastName = split[3];
                String jmbg = split[4];
                String address = split[5];
                int phoneNumber = Integer.parseInt(split[6]);
                int genderInt = Integer.parseInt(split[7]);
                Gender gender = Gender.values()[genderInt];
                boolean deleted = Boolean.parseBoolean(split[8]);
                int id = Integer.parseInt(split[9]);
                int rolesInt = Integer.parseInt(split[10]);
                Roles roles = Roles.values()[rolesInt];
                Customer customer = new Customer(username, password, name, lastName, jmbg, address, phoneNumber, gender, deleted, id, roles);
                customers.add(customer);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadDrivers(String fileName) {
        try {
            File usersFile = new File("src/txtFiles/" + fileName);
            BufferedReader br = new BufferedReader(new FileReader(usersFile));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] split = line.split("\\|");
                String username = split[0];
                String password = split[1];
                String name = split[2];
                String lastName = split[3];
                String jmbg = split[4];
                String address = split[5];
                int phoneNumber = Integer.parseInt(split[6]);
                int genderInt = Integer.parseInt(split[7]);
                Gender gender = Gender.values()[genderInt];
                boolean deleted = Boolean.parseBoolean(split[8]);
                int id = Integer.parseInt(split[9]);
                int rolesInt = Integer.parseInt(split[10]);
                Roles roles = Roles.values()[rolesInt];
                double driverPay = Double.parseDouble(split[11]);
                int membershipCard = Integer.parseInt(split[12]);

                Driver driver = new Driver(username, password, name, lastName, jmbg, address, phoneNumber, gender, deleted, id, roles, driverPay, membershipCard);
                drivers.add(driver);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadCars(String fileName) {
        try {
            File vehiclesFile = new File("src/txtFiles/" + fileName);
            BufferedReader br = new BufferedReader(new FileReader(vehiclesFile));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] split = line.split("\\|");
                String IDCode = split[0];
                int carId = Integer.parseInt(split[1]);
                String model = split[2];
                String manufacturer = split[3];
                int yearProduced = Integer.parseInt(split[4]);
                int registrationNumber = Integer.parseInt(split[5]);
                int taxiNumber = Integer.parseInt(split[6]);
                int vehicleInt = Integer.parseInt(split[7]);
                VehicleType vehicletype = VehicleType.values()[vehicleInt];
                boolean deleted = Boolean.parseBoolean(split[8]);

                Car car = new Car(IDCode, carId, model, manufacturer, yearProduced, registrationNumber, taxiNumber, vehicletype, deleted);
                cars.add(car);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadRides(String fileName) {
        try {
            File vehiclesFile = new File("src/txtFiles/" + fileName);
            BufferedReader br = new BufferedReader(new FileReader(vehiclesFile));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] split = line.split("\\|");
                String rideID = split[0];
                double orderDate = Double.parseDouble(split[1]);
                String startAddress = split[2];
                String destinationAddress = split[3];
                String customerOrder = split[4];
                String driverOrder = split[5];
                double kmPassed = Double.parseDouble(split[6]);
                double rideDuration = Double.parseDouble(split[7]);
                int statusInt = Integer.parseInt(split[8]);
                RideStatus rideStatus = RideStatus.values()[statusInt];
                String customerNote = split[9];
                boolean deleted = Boolean.parseBoolean(split[10]);

                Ride ride = new Ride(rideID, orderDate, startAddress, destinationAddress, customerOrder, driverOrder, kmPassed, rideDuration, rideStatus, customerNote, deleted);
                rides.add(ride);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadInfo(String fileName) {
        try {
            File usersFile = new File("src/txtFiles/" + fileName);
            BufferedReader br = new BufferedReader(new FileReader(usersFile));
            String line = null;
            while ((line = br.readLine()) != null) {
                String[] split = line.split("\\|");
                int PIB = Integer.parseInt(split[0]);
                String TaxiServiceName = split[1];
                String TaxiServiceAddress = split[2];
                double TaxiServiceStartingPrice = Double.parseDouble(split[3]);
                double TaxiServicePricePerKM = Double.parseDouble(split[4]);
                boolean deleted = Boolean.parseBoolean(split[5]);

                TaxiServiceInfo taxiServiceInfo = new TaxiServiceInfo(PIB, TaxiServiceName, TaxiServiceAddress, TaxiServiceStartingPrice, TaxiServicePricePerKM, deleted);
                serviceInfos.add(taxiServiceInfo);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Driver> allNotDeletedDrivers() {
        ArrayList<Driver> notDeleted = new ArrayList<Driver>();
        for (Driver driver : drivers) {
            if(!driver.isDeleted()) {
                notDeleted.add(driver);
            }
        }
        return notDeleted;
    }

    public ArrayList<Dispatcher> allNotDeletedDispatchers() {
        ArrayList<Dispatcher> notDeleted = new ArrayList<Dispatcher>();
        for (Dispatcher dispatcher : dispatchers) {
            if(!dispatcher.isDeleted()) {
                notDeleted.add(dispatcher);
            }
        }
        return notDeleted;
    }

    public ArrayList<Car> allNotDeletedCars() {
        ArrayList<Car> notDeleted = new ArrayList<Car>();
        for (Car car : cars) {
            if(!car.isDeleted()) {
                notDeleted.add(car);
            }
        }
        return notDeleted;
    }

    public ArrayList<Ride> allNotDeletedRides() {
        ArrayList<Ride> notDeleted = new ArrayList<Ride>();
        for (Ride ride : rides) {
            if(!ride.isDeleted()) {
                notDeleted.add(ride);
            }
        }
        return notDeleted;
    }

    public ArrayList<TaxiServiceInfo> allNotDeletedInfo() {
        ArrayList<TaxiServiceInfo> notDeleted = new ArrayList<TaxiServiceInfo>();
        for (TaxiServiceInfo taxiServiceInfo : serviceInfos) {
            if(!taxiServiceInfo.isDeleted()) {
                notDeleted.add(taxiServiceInfo);
            }
        }
        return notDeleted;
    }

    public void saveDrivers(String fileName) {
        try {
            File file = new File("src/txtFiles/" + fileName);
            BufferedWriter br = new BufferedWriter(new FileWriter(file));
            String content = "";
            for (Driver driver: drivers) {
                content += driver.getUsername() + "|" + driver.getPassword() + "|" + driver.getName() + "|"
                        + driver.getLastName() + "|" + driver.getJmbg() + "|" + driver.getAddress() + "|" + driver.getPhoneNumber() + "|" + driver.getGender().ordinal() + "|" + driver.isDeleted() + "|" + driver.getId() + "|" + driver.getRoles().ordinal() + "|" + driver.getDriverPay() + "|" + driver.getMembershipCard() + "\n";
            }
            br.write(content);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveCustomers(String fileName) {
        try {
            File file = new File("src/txtFiles/" + fileName);
            BufferedWriter br = new BufferedWriter(new FileWriter(file));
            String content = "";
            for (Customer customer: customers) {
                content += customer.getUsername() + "|" + customer.getPassword() + "|" + customer.getName() + "|"
                        + customer.getLastName() + "|" + customer.getJmbg() + "|" + customer.getAddress() + "|" + customer.getPhoneNumber() + "|" + customer.getGender().ordinal() + "|" + customer.isDeleted() + "|" + customer.getId() + "|" + customer.getRoles().ordinal() + "\n";
            }
            br.write(content);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveDispatchers(String fileName) {
        try {
            File file = new File("src/txtFiles/" + fileName);
            BufferedWriter br = new BufferedWriter(new FileWriter(file));
            String content = "";
            for (Dispatcher dispatcher: dispatchers) {
                content += dispatcher.getUsername() + "|" + dispatcher.getPassword() + "|" + dispatcher.getName() + "|"
                        + dispatcher.getLastName() + "|" + dispatcher.getJmbg() + "|" + dispatcher.getAddress() + "|" + dispatcher.getPhoneNumber() + "|" + dispatcher.getGender().ordinal() + "|" + dispatcher.isDeleted() + "|" + dispatcher.getId() + "|" + dispatcher.getRoles().ordinal() + "|" + dispatcher.getDispatcherPay() + "|" + dispatcher.getPhoneLine() + "|" + dispatcher.getDepartment().ordinal() + "\n";
            }
            br.write(content);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveCars(String fileName) {
        try {
            File file = new File("src/txtFiles/" + fileName);
            BufferedWriter br = new BufferedWriter(new FileWriter(file));
            String content = "";
            for (Car car: cars) {
                content += car.getIDCode() + "|" + car.getCarID() + "|" + car.getModel() + "|" + car.getManufacturer() + "|" + car.getYearProduced() + "|"
                        + car.getRegistrationNumber() + "|" + car.getTaxiNumber() + "|" + car.getVehicletype().ordinal() + "|" + car.isDeleted() + "\n";
            }
            br.write(content);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveRides(String fileName) {
        try {
            File file = new File("src/txtFiles/" + fileName);
            BufferedWriter br = new BufferedWriter(new FileWriter(file));
            String content = "";
            for (Ride ride: rides) {
                content += ride.getRideID() + "|" + ride.getOrderDate() + "|" + ride.getStartAddress() + "|" + ride.getDestinationAddress() + "|"
                        + ride.getCustomerOrder() + "|" + ride.getDriverOrder() + "|" + ride.getKmPassed() + "|" + ride.getRideDuration() + "|" + ride.getRideStatus().ordinal() + "|" + ride.getCustomerNote() + "|" + ride.isDeleted() +  "\n";
            }
            br.write(content);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveInfo(String fileName) {
        try {
            File file = new File("src/txtFiles/" + fileName);
            BufferedWriter br = new BufferedWriter(new FileWriter(file));
            String content = "";
            for (TaxiServiceInfo taxiServiceInfo: serviceInfos) {
                content += taxiServiceInfo.getPIB() + "|" + taxiServiceInfo.getTaxiServiceName() + "|" + taxiServiceInfo.getTaxiServiceAddress() + "|"
                        + taxiServiceInfo.getTaxiServiceStartingPrice() + "|" + taxiServiceInfo.getTaxiServicePricePerKM() + "|" + taxiServiceInfo.isDeleted() + "\n";
            }
            br.write(content);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}