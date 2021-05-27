package AllUsers;

import Enums.Gender;
import Utils.StringUtils;


public class Customer extends Users {

    protected Person person;

    public Customer(String username, String password, String address, String  phoneNumber, Gender gender, Person person) {
        super(username, password, address, phoneNumber, gender);
        this.person = person;
    }

    @Override
    public String toString() {
        return super.toString() + " " + StringUtils.clean(person.getJmbg());
    }

    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }

}