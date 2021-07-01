package GUI.DispatcherOptions.ReportStatistics;

import javax.swing.*;

public class Statistics {

    private int ridesInTotal;
    private int phoneRidesInTotal;
    private int appRidesInTotal;
    private int activeDrivers;
    private double averageRideDuration;
    private double averageKMPassed;
    private double payForAllRides;
    private double averagePayPerRide;
    private boolean deleted;

    public Statistics() {
        this.ridesInTotal = 0;
        this.phoneRidesInTotal = 0;
        this.appRidesInTotal = 0;
        this.activeDrivers = 0;
        this.averageRideDuration = 0;
        this.averageKMPassed = 0;
        this.payForAllRides = 0;
        this.averagePayPerRide = 0;
        this.deleted = false;
    }

    public Statistics(int ridesInTotal, int phoneRidesInTotal, int appRidesInTotal, int activeDrivers, double averageRideDuration, double averageKMPassed, double payForAllRides, double averagePayPerRide, boolean deleted) {
        super();
        this.ridesInTotal = ridesInTotal;
        this.phoneRidesInTotal = phoneRidesInTotal;
        this.appRidesInTotal = appRidesInTotal;
        this.activeDrivers = activeDrivers;
        this.averageRideDuration = averageRideDuration;
        this.averageKMPassed = averageKMPassed;
        this.payForAllRides = payForAllRides;
        this.averagePayPerRide = averagePayPerRide;
        this.deleted = deleted;
    }

    public int getRidesInTotal() {return ridesInTotal;}
    public void setRidesInTotal(int ridesInTotal) {this.ridesInTotal = ridesInTotal;}

    public int getPhoneRidesInTotal() {return phoneRidesInTotal;}
    public void setPhoneRidesInTotal(int phoneRidesInTotal) {this.phoneRidesInTotal = phoneRidesInTotal;}

    public int getAppRidesInTotal() {return appRidesInTotal;}
    public void setAppRidesInTotal(int appRidesInTotal) {this.appRidesInTotal = appRidesInTotal;}

    public int getActiveDrivers() {return activeDrivers;}
    public void setActiveDrivers(int activeDrivers) {this.activeDrivers = activeDrivers;}

    public double getAverageRideDuration() {return averageRideDuration;}
    public void setAverageRideDuration(double averageRideDuration) { this.averageRideDuration = averageRideDuration; }

    public double getAverageKMPassed() {return averageKMPassed;}
    public void setAverageKMPassed(double averageKMPassed) { this.averageKMPassed = averageKMPassed; }

    public double getPayForAllRides() {return payForAllRides;}
    public void setPayForAllRides(double payForAllRides) { this.payForAllRides = payForAllRides; }

    public double getAveragePayPerRide() {return averagePayPerRide;}
    public void setAveragePayPerRide(double averagePayPerRide) { this.averagePayPerRide = averagePayPerRide; }

    public boolean isDeleted() {
        return deleted;
    }
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Statistics \nRides in Total: " + ridesInTotal +
                "\nPhone Rides in Total: " + phoneRidesInTotal +
                "\nApp Rides in Total: " + appRidesInTotal +
                "\nActive Drivers: " + activeDrivers +
                "\nAverage Ride Duration: " + averageRideDuration +
                "\nAverage KM Passed: " + averageKMPassed +
                "\nPay for All Rides: " + payForAllRides +
                "\nAverage Pay per Ride: " + averagePayPerRide +
                "\nDeleted: " + deleted;
    }

}
