package rides;

import allUsers.Driver;
import enums.RideStatus;
import java.time.LocalDate;
import java.time.LocalTime;



public class Ride {

    private double orderDate;
    private double orderTime;
    private String startAddress;
    private String destinationAddress;
    private String customerOrder;
    private String driverOrder;
    private double kmPassed;
    private double rideDuration;
    private RideStatus rideStatus;
    // Rezervacije putem Telefona i Aplikacije fale----

    public Ride() {

        this.orderDate = 0;
        this.orderTime = 0;
        this.startAddress = "";
        this.destinationAddress = "";
        this.customerOrder = "";
        this.driverOrder = "";
        this.kmPassed = 0;
        this.rideDuration = 0;
        this.rideStatus = RideStatus.Created;

    }



}
