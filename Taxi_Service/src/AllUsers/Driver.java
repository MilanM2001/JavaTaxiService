package AllUsers;

import Enums.Gender;
import Utils.StringUtils;

public class Driver extends Users {

    protected double driverPay;
    protected String membershipCard;

    public Driver(String username, String password, String name, String lastName, String jmbg, String address, String phoneNumber, Gender gender, double driverPay, String membershipCard) {

        super(username, password, name, lastName, jmbg, address, phoneNumber, gender);
        this.driverPay = driverPay;
        this.membershipCard = membershipCard;

    }

    @Override
    public String toString() {
        return super.toString() + " " + driverPay + " " + StringUtils.clean(membershipCard);
    }

    public double getDriverPay() {return driverPay;}
    public void setDriverPay(double driverPay) {this.driverPay = driverPay;}

    public String getMembershipCard() {return membershipCard;}
    public void setMembershipCard(String membershipCard) {this.membershipCard = membershipCard;}

}