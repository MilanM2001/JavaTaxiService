package main;

import allUsers.Driver;
import allUsers.Gender;
import cars.Car;
import cars.VehicleType;

import java.io.*;
import java.util.ArrayList;

public class TaxiService {

    private ArrayList<Driver> drivers;
    private ArrayList<Car> cars;


    public TaxiService() {
        this.drivers = new ArrayList<Driver>();
        this.cars = new ArrayList<Car>();
    }

    public ArrayList<Driver> getDrivers() {return drivers;}
    public void addDriver(Driver driver) { this.drivers.add(driver); }

    public ArrayList<Car> getCars() {return cars;}
    public void addCar(Car car) { this.cars.add(car); }

    public void loadVehicles(String fileName) {
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

                Car car = new Car(model, manufacturer, yearProduced, registrationNumber, taxiNumber, vehicletype);
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

    public void loadDrivers(String fileName) {
        try {
            File driversFile = new File("src/txtFiles/" + fileName);
            BufferedReader br = new BufferedReader(new FileReader(driversFile));
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

                Driver driver = new Driver(username, password, name, lastName, jmbg, address, phoneNumber, gender);
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





}