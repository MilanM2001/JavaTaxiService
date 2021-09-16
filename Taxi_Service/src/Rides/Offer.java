package Rides;

import AllUsers.Driver;
import GUI.DispatcherOptions.ReportStatistics.DateUtils;

import java.time.LocalDateTime;

public class Offer {

    public Offer() {
    }

    private long id;

    private int minutes;
    private LocalDateTime dateOfCreation;

    private long orderId;
    private long driverId;

    private boolean deleted;

    private Ride ride;
    private Driver driver;

    public Offer(int minutes, Ride ride, Driver driver) {
        this.minutes = minutes;
        this.ride = ride;
        this.driver = driver;
        this.orderId = ride.getRideID();
        this.driverId = driver.getId();
        this.dateOfCreation = LocalDateTime.now();
    }

    public String serialize() {
        return getId() + "|" + getMinutes() + "|" +
                DateUtils.serializeLocalDateTime(getDateOfCreation()) + "|"
                + getOrderId() + "|" + getDriverId() + "|" + isDeleted();
    }

    public static Offer deserialize(String offerString) {
        String[] fields = offerString.replaceAll("\n", "").split("[|]");

        Offer offer = new Offer();

        offer.setId(Long.parseLong(fields[0]));
        offer.setMinutes(Integer.parseInt(fields[1]));
        offer.setDateOfCreation(DateUtils.deserializeLocalDateTime(fields[2]));
        offer.setOrderId(Long.parseLong(fields[3]));
        offer.setDriverId(Long.parseLong(fields[4]));
        offer.setDeleted(Boolean.parseBoolean(fields[5]));

        return offer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public LocalDateTime getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(LocalDateTime dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
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
}
