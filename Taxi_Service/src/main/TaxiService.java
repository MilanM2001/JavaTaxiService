package main;

import allUsers.Driver;
import allUsers.Gender;

import java.io.*;
import java.util.ArrayList;

public class TaxiService {

    private ArrayList<Driver> drivers;


    public TaxiService() {
        this.drivers = new ArrayList<Driver>();
    }

    public ArrayList<Driver> getDrivers() {return drivers;}
    public void addDriver(Driver driver) { this.drivers.add(driver); }







//    public ArrayList<Driver> undeletedDrivers() {
//        ArrayList<Driver> undeleted = new ArrayList<Driver>();
//        for (Driver driver : drivers) {
//            if(!driver.isDeleted()) {
//                undeleted.add(driver);
//            }
//        }
//        return undeleted;
//    }


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