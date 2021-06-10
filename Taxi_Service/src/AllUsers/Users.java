package AllUsers;

import Enums.Gender;
import Enums.Roles;

public abstract class Users {
    protected String username;
    protected String password;
    protected String name;
    protected String lastName;
    protected String jmbg;
    protected String address;
    protected int phoneNumber;
    protected Gender gender;
    protected boolean deleted;
    protected int id;
    protected Roles roles;

    public Users() {
        this.username = "";
        this.password = "";
        this.name = "";
        this.lastName = "";
        this.jmbg = "";
        this.address = "";
        this.phoneNumber = 0;
        this.gender = Gender.Male;
        this.deleted = false;
        this.id = 0;
        this.roles = Roles.Dispatcher;
    }

    public Users(String username, String password,String name, String lastName, String jmbg, String address, int phoneNumber, Gender gender, boolean deleted, int id, Roles roles) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.jmbg = jmbg;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.deleted = deleted;
        this.id = id;
        this.roles = roles;
    }

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

    public int getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(int phoneNumber) {this.phoneNumber = phoneNumber;}

    public Gender getGender() {return gender;}
    public void setGender(Gender gender) { this.gender = gender; }

    public boolean isDeleted() {
        return deleted;
    }
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public Roles getRoles() {return roles;}
    public void setRoles(Roles roles) { this.roles = roles; }

}
