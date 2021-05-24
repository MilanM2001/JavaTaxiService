package AllUsers;

import Enums.Department;
import Enums.Gender;
import Utils.StringUtils;

public class Dispatcher extends Users {

    protected double dispatcherPay;
    protected String phoneLine;
    protected Department department;

    public Dispatcher(String username, String password, String name, String lastName, String jmbg, String address, String phoneNumber, Gender gender, double dispatcherPay, String phoneLine, Department department) {

        super(username, password, name, lastName, jmbg, address, phoneNumber, gender);
        this.dispatcherPay = dispatcherPay;
        this.phoneLine = phoneLine;
        this.department = department;

    }

    @Override
    public String toString() {
        return super.toString() + " " + dispatcherPay + " " + StringUtils.clean(phoneLine) + " " + department;
    }





    public double getDispatcherPay() {return dispatcherPay;}
    public void setDispatcherPay(double dispatcherPay) {this.dispatcherPay = dispatcherPay;}

    public String getPhoneLine() {return phoneLine;}
    public void setPhoneLine(String phoneLine) {this.phoneLine = phoneLine;}

    public Department getDepartment() {return department;}
    public void setDepartment(Department department) { this.department = department; }

}