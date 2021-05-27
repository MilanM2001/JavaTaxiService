package AllUsers;

import Enums.Department;
import Enums.Gender;
import Utils.StringUtils;

public class Dispatcher extends Users {

    protected double dispatcherPay;
    protected String phoneLine;
    protected Department department;
    protected Person person;

    public Dispatcher(String username, String password, String address, String phoneNumber, Gender gender,Person person, double dispatcherPay, String phoneLine, Department department) {

        super(username, password, address, phoneNumber, gender);
        this.person = person;
        this.dispatcherPay = dispatcherPay;
        this.phoneLine = phoneLine;
        this.department = department;

    }

    @Override
    public String toString() {
        return super.toString() + " " + StringUtils.clean(person.getJmbg()) + " " + dispatcherPay + " " + StringUtils.clean(phoneLine) + " " + department;
    }


    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }

    public double getDispatcherPay() {return dispatcherPay;}
    public void setDispatcherPay(double dispatcherPay) {this.dispatcherPay = dispatcherPay;}

    public String getPhoneLine() {return phoneLine;}
    public void setPhoneLine(String phoneLine) {this.phoneLine = phoneLine;}

    public Department getDepartment() {return department;}
    public void setDepartment(Department department) { this.department = department; }

}