package Rides;

import AllUsers.Driver;
import GUI.DispatcherOptions.ReportStatistics.DateUtils;

import java.time.LocalDateTime;

public class Offer {

    private int orderId;
    private int minutes;
    private String dateOfCreation;
    private boolean deleted;
    private int rideID;
    private int driverID;
    private Ride ride;
    private Driver driver;

    public Offer() {
        this.orderId = 0;
        this.minutes = 0;
        this.dateOfCreation = "";
        this.deleted = false;
        this.rideID = ride.getRideID();
        this.driverID = driver.getId();
    }

    public Offer(int orderId, int minutes, String dateOfCreation, boolean deleted, int rideID, int driverID) {
        this.orderId = orderId;
        this.minutes = minutes;
        this.dateOfCreation = dateOfCreation;
        this.deleted = deleted;
        this.rideID = rideID;
        this.driverID = driverID;

    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public String getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(String dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public int getRideID() {
        return rideID;
    }

    public void setRideID(int rideID) {
        this.rideID = rideID;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Offer \nOffer ID: " + orderId +
                "\nMinutes: " + minutes +
                "\nDate of Creation: " + dateOfCreation +
                "\nDeleted: " + deleted +
                "\nRide ID: " + rideID +
                "\nDriver ID: " + driverID;
    }
}
