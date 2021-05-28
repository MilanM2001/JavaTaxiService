package Main;

import AllUsers.Customer;
import AllUsers.Dispatcher;
import AllUsers.Driver;
import Enums.Department;
import Enums.Gender;
import Cars.Car;
import Enums.Roles;
import Enums.VehicleType;

import java.io.*;
import java.util.ArrayList;

public class TaxiService {

    private ArrayList<Driver> drivers;
    private ArrayList<Customer> customers;
    private ArrayList<Dispatcher> dispatchers;
    private ArrayList<Car> cars;

    public TaxiService() {
        this.drivers = new ArrayList<Driver>();
        this.customers = new ArrayList<Customer>();
        this.dispatchers = new ArrayList<Dispatcher>();
        this.cars = new ArrayList<Car>();
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

//    public Car findCar(int carID) {
//        for (Car car : cars) {
//            if (car.getCarID().equals(carID)) {
//                return car;
//            }
//        }
//        return null;
//    }


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
                int carId = Integer.parseInt(split[0]);
                String model = split[1];
                String manufacturer = split[2];
                int yearProduced = Integer.parseInt(split[3]);
                int registrationNumber = Integer.parseInt(split[4]);
                int taxiNumber = Integer.parseInt(split[5]);
                int vehicleInt = Integer.parseInt(split[6]);
                VehicleType vehicletype = VehicleType.values()[vehicleInt];
                boolean deleted = Boolean.parseBoolean(split[7]);

                Car car = new Car(carId, model, manufacturer, yearProduced, registrationNumber, taxiNumber, vehicletype, deleted);
                cars.add(car);
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

    public void saveDrivers(String fileName) {
        try {
            File file = new File("src/txtFiles/" + fileName);
            BufferedWriter br = new BufferedWriter(new FileWriter(file));
            String content = "";
            for (Driver driver: drivers) {
                content += driver.getUsername() + "|" + driver.getPassword() + "|" + driver.getName() + "|"
                        + driver.getLastName() + "|" + driver.getJmbg() + "|" + driver.getAddress() + "|" + driver.getPhoneNumber() + "|" + driver.getGender().ordinal() + "|" + driver.isDeleted() + "|" + driver.getId() + "|" + driver.getRoles() + "|" + driver.getDriverPay() + "|" + driver.getMembershipCard() + "\n";
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
                        + customer.getLastName() + "|" + customer.getJmbg() + "|" + customer.getAddress() + "|" + customer.getPhoneNumber() + "|" + customer.getGender().ordinal() + "|" + customer.isDeleted() + "|" + customer.getId() + "|" + customer.getRoles() + "\n";
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
                        + dispatcher.getLastName() + "|" + dispatcher.getJmbg() + "|" + dispatcher.getAddress() + "|" + dispatcher.getPhoneNumber() + "|" + dispatcher.getGender().ordinal() + "|" + dispatcher.isDeleted() + "|" + dispatcher.getId() + "|" + dispatcher.getRoles() + "|" + dispatcher.getDispatcherPay() + "|" + dispatcher.getPhoneLine() + "|" + dispatcher.getDepartment().ordinal() + "\n";
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
                content += car.getCarID() + "|" + car.getModel() + "|" + car.getManufacturer() + "|" + car.getYearProduced() + "|"
                        + car.getRegistrationNumber() + "|" + car.getTaxiNumber() + "|" + car.getVehicletype().ordinal() + "|" + car.isDeleted() + "\n";
            }
            br.write(content);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}