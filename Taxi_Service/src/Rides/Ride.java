package Rides;

import Enums.RideStatus;
import Enums.VehicleType;

import java.time.LocalDateTime;

public class Ride {

//    private LocalDateTime orderDate;
    private String rideID;
    private double orderDate;
    private String startAddress;
    private String destinationAddress;
    private String customerOrder;
    private String driverOrder;
    private double kmPassed;
    private double rideDuration;
    private RideStatus rideStatus;
    private boolean deleted;
    // Rezervacije putem Telefona i Aplikacije fale----

    public Ride() {
        this.rideID = "";
        this.orderDate = 0;
        this.startAddress = "";
        this.destinationAddress = "";
        this.customerOrder = "";
        this.driverOrder = "";
        this.kmPassed = 0;
        this.rideDuration = 0;
        this.rideStatus = RideStatus.Created;
        this.deleted = false;
    }

    public Ride(String rideID, double orderDate, String startAddress, String destinationAddress, String customerOrder, String driverOrder, double kmPassed, double rideDuration, RideStatus rideStatus, boolean deleted) {
        super();
        this.rideID = rideID;
        this.orderDate = orderDate;
        this.startAddress = startAddress;
        this.destinationAddress = destinationAddress;
        this.customerOrder = customerOrder;
        this.driverOrder = driverOrder;
        this.kmPassed = kmPassed;
        this.rideDuration = rideDuration;
        this.rideStatus = rideStatus;
        this.deleted = deleted;
    }

    public String getRideID() {return rideID;}
    public void setRideID(String rideID) { this.rideID = rideID; }

    public double getOrderDate() {return orderDate;}
    public void setOrderDate(double orderDate) { this.orderDate = orderDate; }

    public String getStartAddress() {return startAddress;}
    public void setStartAddress(String startAddress) { this.startAddress = startAddress; }

    public String getDestinationAddress() {return destinationAddress;}
    public void setDestinationAddress(String destinationAddress) { this.destinationAddress = destinationAddress; }

    public String getCustomerOrder() {return customerOrder;}
    public void setCustomerOrder(String customerOrder) { this.customerOrder = customerOrder; }

    public String getDriverOrder() {return driverOrder;}
    public void setDriverOrder(String driverOrder) { this.driverOrder = driverOrder; }

    public double getKmPassed() {return kmPassed;}
    public void setKmPassed(double kmPassed) { this.kmPassed = kmPassed; }

    public double getRideDuration() {return rideDuration;}
    public void setRideDuration(double rideDuration) { this.rideDuration = rideDuration; }

    public RideStatus getRideStatus() { return rideStatus;}
    public void setRideStatus(RideStatus rideStatus) {this.rideStatus = rideStatus;}

    public boolean isDeleted() {
        return deleted;
    }
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Ride \nRide ID: " + rideID +
                "\nOrder Date: " + orderDate +
                "\nStart Address: " + startAddress +
                "\nDestination Address: " + destinationAddress +
                "\nCustomer: " + customerOrder +
                "\nDriver: " + driverOrder +
                "\nKM Passed: " + kmPassed +
                "\nRide Duration: " + rideDuration +
                "\nRide Status: " + rideStatus +
                "\nDeleted: " + deleted;
    }
}
