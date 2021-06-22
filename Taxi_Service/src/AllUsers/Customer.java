package AllUsers;

import Enums.Gender;
import Enums.Roles;

public class Customer extends Users {

    public Customer(String username, String password, String name, String lastName, String jmbg, String address, int phoneNumber, Gender gender, boolean deleted, int id, Roles roles) {
        super(username, password, name, lastName, jmbg, address, phoneNumber, gender, deleted, id, roles);
    }

    @Override
    public String toString() {
        return "Customer \nUsername: " + username +
                "\nPassword: " + password +
                "\nName: " + name +
                "\nLast Name: " + lastName +
                "\nJMBG: " + jmbg +
                "\nAddress: " + address +
                "\nPhone Number: " + phoneNumber +
                "\nGender" + gender +
                "\nDeleted: " + deleted +
                "\nID: " + id +
                "\nRoles: " + roles;
    }

}