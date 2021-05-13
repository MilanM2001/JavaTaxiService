package allUsers;

import cars.Car;
import cars.VehicleType;

import java.util.*;


public class Driver {

    private String username;
    private String password;
    private String name;
    private String lastName;
    private int jmbg;
    private String address;
    private int phoneNumber;
    private Gender gender;
    private int driverPay;
    private int membershipCard;

    public Driver() {

        this.username = "";
        this.password = "";
        this.name = "";
        this.lastName = "";
        this.jmbg = 0;
        this.address = "";
        this.phoneNumber = 0;
        this.gender = Gender.Male;
        this.driverPay = 0;
        this.membershipCard = 0;

    }

    public Driver(String username, String password, String name, String lastName, int jmbg, String address, int phoneNumber, Gender gender, int driverPay, int membershipCard) {

        super();
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.jmbg = jmbg;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.driverPay = driverPay;
        this.membershipCard = membershipCard;

    }

    public String getUsername() {return username;}
    public void setUsername(String username) { this.username = username; }

    public String getPassword() {return password;}
    public void setPassword(String password) { this.password = password; }

    public String getName() {return name;}
    public void setName(String name) { this.name = name; }

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) { this.name = name; }

    public int getJmbg() {return jmbg;}
    public void setJmbg(int jmbg) { this.jmbg = jmbg; }

    public String getAddress() {return address;}
    public void setAddress(String address) { this.address = address; }

    public int getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(int phoneNumber) { this.phoneNumber = phoneNumber; }

    public Gender getGender() {return gender;}
    public void setGender(Gender gender) { this.gender = gender; }

    public int getDriverPay() {return driverPay;}
    public void setDriverPay(int driverPay) { this.driverPay = driverPay; }

    public int getMembershipCard() {return membershipCard;}
    public void setMembershipCard(int membershipCard) { this.membershipCard = membershipCard;}

    @Override
    public String toString() {
        return "Driver \nUsername: " + username +
                "\nPassword: " + password +
                "\nName: " + name +
                "\nLast Name: " + lastName +
                "\nJMBG: " + jmbg +
                "\nAddress: " + address +
                "\nPhone Number " + phoneNumber +
                "\nGender: " + gender;
    }

}