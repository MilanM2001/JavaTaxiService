package allUsers;

import enums.Gender;
import enums.Roles;


public class Customer  {

    private String username;
    private String password;
    private String name;
    private String lastName;
    private int jmbg;
    private String address;
    private int phoneNumber;
    private Gender gender;
    private boolean deleted;


    public Customer() {

        this.username = "";
        this.password = "";
        this.name = "";
        this.lastName = "";
        this.jmbg = 0;
        this.address = "";
        this.phoneNumber = 0;
        this.gender = Gender.Male;
        this.deleted = false;

    }

    public Customer(String username, String password, String name, String lastName, int jmbg, String address, int phoneNumber, Gender gender, boolean deleted) {

        super();
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.jmbg = jmbg;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
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
                "\nGender: " + gender;
    }


}