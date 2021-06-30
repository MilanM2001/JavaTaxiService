package Rides;

import Enums.RideOrderType;
import Enums.RideStatus;

public class Ride {

    private int rideID;
    private String orderDate;
    private String startAddress;
    private String destinationAddress;
    private String  customerOrder;
    private int driverOrder;
    private double kmPassed;
    private double rideDuration;
    private RideStatus rideStatus;
    private String customerNote;
    private RideOrderType rideOrderType;
    private boolean deleted;

    public Ride() {
        this.rideID = 0;
        this.orderDate = "";
        this.startAddress = "";
        this.destinationAddress = "";
        this.customerOrder = "";
        this.driverOrder = 0;
        this.kmPassed = 0;
        this.rideDuration = 0;
        this.rideStatus = RideStatus.Created;
        this.rideOrderType = RideOrderType.Phone;
        this.customerNote = "";
        this.deleted = false;
    }

    public Ride(int rideID, String orderDate, String startAddress, String destinationAddress, String customerOrder, int driverOrder, double kmPassed, double rideDuration, RideStatus rideStatus, String customerNote, RideOrderType rideOrderType, boolean deleted) {
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
        this.customerNote = customerNote;
        this.rideOrderType = rideOrderType;
        this.deleted = deleted;
    }

    public int getRideID() {return rideID;}
    public void setRideID(int rideID) {this.rideID = rideID;}

    public String getOrderDate() {return orderDate;}
    public void setOrderDate(String orderDate) {this.orderDate = orderDate;}

    public String getStartAddress() {return startAddress;}
    public void setStartAddress(String startAddress) {this.startAddress = startAddress;}

    public String getDestinationAddress() {return destinationAddress;}
    public void setDestinationAddress(String destinationAddress) {this.destinationAddress = destinationAddress;}

    public String getCustomerOrder() {return customerOrder;}
    public void setCustomerOrder(String  customerOrder) {this.customerOrder = customerOrder;}

    public int getDriverOrder() {return driverOrder;}
    public void setDriverOrder(int driverOrder) {this.driverOrder = driverOrder;}

    public double getKmPassed() {return kmPassed;}
    public void setKmPassed(double kmPassed) { this.kmPassed = kmPassed; }

    public double getRideDuration() {return rideDuration;}
    public void setRideDuration(double rideDuration) {this.rideDuration = rideDuration;}

    public RideStatus getRideStatus() {return rideStatus;}
    public void setRideStatus(RideStatus rideStatus) {this.rideStatus = rideStatus;}

    public String getCustomerNote() {return customerNote;}
    public void setCustomerNote(String customerNote) {this.customerNote = customerNote;}

    public RideOrderType getRideOrderType() {return rideOrderType;}
    public void setRideOrderType(RideOrderType rideOrderType) {this.rideOrderType = rideOrderType;}

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
                "\nCustomer Note: " + customerNote +
                "\nOrder Type: " + rideOrderType +
                "\nDeleted: " + deleted;
    }
}
