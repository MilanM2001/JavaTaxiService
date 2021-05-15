package main;

import allUsers.Customer;
import allUsers.Dispatcher;
import allUsers.Driver;
import enums.Department;
import enums.Gender;
import cars.Car;
import enums.Roles;
import enums.VehicleType;

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
    public void addDriver(Driver driver) { this.drivers.add(driver); }

    public ArrayList<Customer> getCustomers() {return customers;}
    public void addCustomer(Customer customer) { this.customers.add(customer); }

    public ArrayList<Dispatcher> getDispatchers() {return dispatchers;}
    public void addDispatcher(Dispatcher dispatcher) { this.dispatchers.add(dispatcher); }

    public ArrayList<Car> getCars() {return cars;}
    public void addCar(Car car) { this.cars.add(car); }

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
                int jmbg = Integer.parseInt(split[4]);
                String address = split[5];
                int phoneNumber = Integer.parseInt(split[6]);
                int genderInt = Integer.parseInt(split[7]);
                Gender gender = Gender.values()[genderInt];
                int driverPay = Integer.parseInt(split[8]);
                int membershipCard = Integer.parseInt(split[9]);
                boolean deleted = Boolean.parseBoolean(split[10]);

                Driver driver = new Driver(username, password, name, lastName, jmbg, address, phoneNumber, gender, driverPay, membershipCard, deleted);
                drivers.add(driver);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveDrivers(String fileName) {
        try {
            File file = new File("src/txtFiles/" + fileName);
            BufferedWriter br = new BufferedWriter(new FileWriter(file));
            String content = "";
            for (Driver driver: drivers) {
                content += driver.getUsername() + "|" + driver.getPassword() + "|" + driver.getName() + "|"
                        + driver.getLastName() + "|" + driver.getJmbg() + "|" + driver.getAddress() + "|" + driver.getPhoneNumber() + "|" + driver.getGender().ordinal() + "\n";
            }
            br.write(content);
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
                int jmbg = Integer.parseInt(split[4]);
                String address = split[5];
                int phoneNumber = Integer.parseInt(split[6]);
                int genderInt = Integer.parseInt(split[7]);
                Gender gender = Gender.values()[genderInt];
                boolean deleted = Boolean.parseBoolean(split[8]);

                Customer customer = new Customer(username, password, name, lastName, jmbg, address, phoneNumber, gender, deleted);
                customers.add(customer);
            }
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
                        + customer.getLastName() + "|" + customer.getJmbg() + "|" + customer.getAddress() + "|" + customer.getPhoneNumber() + "|" + customer.getGender().ordinal() + "|" + customer.isDeleted() + "\n";
            }
            br.write(content);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                int jmbg = Integer.parseInt(split[4]);
                String address = split[5];
                int phoneNumber = Integer.parseInt(split[6]);
                int genderInt = Integer.parseInt(split[7]);
                Gender gender = Gender.values()[genderInt];
                int dispatcherPay = Integer.parseInt(split[8]);
                int phoneLine = Integer.parseInt(split[9]);
                int departmentInt = Integer.parseInt(split[10]);
                Department department = Department.values()[departmentInt];
                boolean deleted = Boolean.parseBoolean(split[11]);

                Dispatcher dispatcher = new Dispatcher(username, password, name, lastName, jmbg, address, phoneNumber, gender,dispatcherPay, phoneLine, department, deleted);
                dispatchers.add(dispatcher);
            }
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
                        + dispatcher.getLastName() + "|" + dispatcher.getJmbg() + "|" + dispatcher.getAddress() + "|" + dispatcher.getPhoneNumber() + "|" +
                        dispatcher.getGender().ordinal() + "|" + dispatcher.getDispatcherPay() + "|" + dispatcher.getPhoneLine() + "|" + dispatcher.getDepartment().ordinal() + "|" + dispatcher.isDeleted() + "\n";
            }
            br.write(content);
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
                String model = split[0];
                String manufacturer = split[1];
                int yearProduced = Integer.parseInt(split[2]);
                int registrationNumber = Integer.parseInt(split[3]);
                int taxiNumber = Integer.parseInt(split[4]);
                int vehicleInt = Integer.parseInt(split[5]);
                VehicleType vehicletype = VehicleType.values()[vehicleInt];
                boolean deleted = Boolean.parseBoolean(split[6]);

                Car car = new Car(model, manufacturer, yearProduced, registrationNumber, taxiNumber, vehicletype, deleted);
                cars.add(car);
            }
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
                content += car.getModel() + "|" + car.getManufacturer() + "|" + car.getYearProduced() + "|"
                        + car.getRegistrationNumber() + "|" + car.getTaxiNumber() + "|" + car.getVehicletype().ordinal() + "\n";
            }
            br.write(content);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}