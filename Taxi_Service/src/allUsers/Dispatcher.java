package allUsers;

import enums.Department;
import enums.Gender;
import enums.Roles;

public class Dispatcher {

    private String username;
    private String password;
    private String name;
    private String lastName;
    private int jmbg;
    private String address;
    private int phoneNumber;
    private Gender gender;
    private int dispatcherPay;
    private int phoneLine;
    private Department department;
    private boolean deleted;


    public Dispatcher() {

        this.username = "";
        this.password = "";
        this.name = "";
        this.lastName = "";
        this.jmbg = 0;
        this.address = "";
        this.phoneNumber = 0;
        this.gender = Gender.Male;
        this.dispatcherPay = 0;
        this.phoneLine = 0;
        this.department = Department.Reception;
        this.deleted = false;

    }

    public Dispatcher(String username, String password, String name, String lastName, int jmbg, String address, int phoneNumber, Gender gender, int dispatcherPay, int phoneLine, Department department, boolean deleted) {

        super();
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.jmbg = jmbg;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.dispatcherPay = dispatcherPay;
        this.phoneLine = phoneLine;
        this.department = department;
        this.deleted = deleted;

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

    public int getDispatcherPay() {return dispatcherPay;}
    public void setDispatcherPay(int DispatcherPay) { this.dispatcherPay = DispatcherPay; }

    public int getPhoneLine() {return phoneLine;}
    public void setPhoneLine(int phoneLine) { this.phoneLine = phoneLine; }

    public Department getDepartment() {return department;}
    public void setDepartment(Department department) { this.department = department; }

    public boolean isDeleted() {
        return deleted;
    }
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Dispatcher \nUsername: " + username +
                "\nPassword: " + password +
                "\nName: " + name +
                "\nLast Name: " + lastName +
                "\nJMBG: " + jmbg +
                "\nAddress: " + address +
                "\nPhone Number " + phoneNumber +
                "\nGender: " + gender +
                "\nPay: " + dispatcherPay +
                "\nPhone Line: " + phoneLine +
                "\nDepartment: " + department;
    }

}