package AllUsers;

import Enums.Gender;
import Utils.StringUtils;


public class Customer extends Users  {

    public Customer(String username, String password, String name, String lastName, String jmbg, String address, String  phoneNumber, Gender gender) {
        super(username, password, name, lastName, jmbg, address, phoneNumber, gender);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}