package AllUsers;

import Enums.Gender;
import Utils.StringUtils;

public abstract class Users {

    protected String username;
    protected String password;
    protected String name;
    protected String lastName;
    protected String jmbg;
    protected String address;
    protected String phoneNumber;
    protected Gender gender;

    public Users(String username, String password, String name, String lastName, String jmbg, String address, String phoneNumber, Gender gender) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.jmbg = jmbg;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }


    @Override
    public String toString() { return StringUtils.clean(username) + " " + StringUtils.clean(password) + " " + StringUtils.clean(name) + " " + StringUtils.clean(lastName) + " " + StringUtils.clean(jmbg) + " " + StringUtils.clean(address) + " " + StringUtils.clean(phoneNumber) + " " + gender; }

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getJmbg() {return jmbg;}
    public void setJmbg(String jmbg) {this.jmbg = jmbg;}

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    public Gender getGender() {return gender;}
    public void setGender(Gender gender) { this.gender = gender; }

    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String username) {this.phoneNumber = phoneNumber;}

}
