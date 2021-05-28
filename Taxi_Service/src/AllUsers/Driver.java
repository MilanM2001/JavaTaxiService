package AllUsers;

import Enums.Gender;
import Enums.Roles;

public class Driver extends Users {

    protected double driverPay;
    protected int membershipCard;
    //protected Car car;

    public Driver(String username, String password, String name, String lastName, String jmbg, String address, int phoneNumber, Gender gender, boolean deleted, int id, Roles roles, double driverPay, int membershipCard) {
        super(username, password, name, lastName, jmbg, address, phoneNumber, gender, deleted, id, roles);
        this.driverPay = driverPay;
        this.membershipCard = membershipCard;
        //this.car = car;
    }

    public double getDriverPay() {return driverPay;}
    public void setDriverPay(double driverPay) {this.driverPay = driverPay;}

    public int getMembershipCard() {return membershipCard;}
    public void setMembershipCard(int membershipCard) {this.membershipCard = membershipCard;}

//    public Car getCar() {return car;}
//    public void setCar(Car car) {this.car = car;}

    @Override
    public String toString() {
        return "Driver \nUsername: " + username +
                "\nPassword: " + password +
                "\nName: " + name +
                "\nLast Name: " + lastName +
                "\nJMBG: " + jmbg +
                "\nAddress: " + address +
                "\nPhone Number: " + phoneNumber +
                "\nGender" + gender +
                "\nDeleted: " + deleted +
                "\nID: " + id +
                "\nRoles: " + roles +
                "\nPay: " + driverPay +
                "\nMembership Card: " + membershipCard;
    }

}