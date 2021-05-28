package AllUsers;

import Enums.Department;
import Enums.Gender;
import Enums.Roles;

public class Dispatcher extends Users {

    protected double dispatcherPay;
    protected int phoneLine;
    protected Department department;

    public Dispatcher(String username, String password, String name, String lastName, String jmbg, String address, int phoneNumber, Gender gender, boolean deleted, int id, Roles roles, double dispatcherPay, int phoneLine, Department department) {
        super(username, password, name, lastName, jmbg, address, phoneNumber, gender, deleted, id, roles);
        this.dispatcherPay = dispatcherPay;
        this.phoneLine = phoneLine;
        this.department = department;
    }

    public double getDispatcherPay() {return dispatcherPay;}
    public void setDispatcherPay(double dispatcherPay) {this.dispatcherPay = dispatcherPay;}

    public int getPhoneLine() {return phoneLine;}
    public void setPhoneLine(int phoneLine) {this.phoneLine = phoneLine;}

    public Department getDepartment() {return department;}
    public void setDepartment(Department department) { this.department = department; }

    @Override
    public String toString() {
        return "Dispatcher \nUsername: " + username +
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
                "\nPay: " + dispatcherPay +
                "\nPhone Line: " + phoneLine +
                "\nDepartment: " + department;
    }

}