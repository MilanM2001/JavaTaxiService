package cars;

import allUsers.Driver;


public class Car {

    private String model;
    private String manufacturer;
    private int yearProduced;
    private int registrationNumber;
    private int taxiNumber;
    private VehicleType vehicletype;


    public Car() {

        this.model = "";
        this.manufacturer = "";
        this.yearProduced = 0;
        this.registrationNumber = 0;
        this.taxiNumber = 0;
        this.vehicletype = VehicleType.PassengerVehicle;

    }

    public Car(String model, String manufacturer, int yearProduced, int registrationNumber, int taxiNumber, VehicleType vehicletype) {

        super();
        this.model = model;
        this.manufacturer = manufacturer;
        this.yearProduced = yearProduced;
        this.registrationNumber = registrationNumber;
        this.taxiNumber = taxiNumber;
        this.vehicletype = vehicletype;

    }

    public String getModel() {return model;}
    public void setModel(String model) { this.model = model; }

    public String getManufacturer() {return manufacturer;}
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public int getYearProduced() {return yearProduced;}
    public void setYearProduced(int yearProduced) { this.yearProduced = yearProduced; }

    public int getRegistrationNumber() {return registrationNumber;}
    public void setRegistrationNumber(int registrationNumber) { this.registrationNumber = registrationNumber; }

    public int getTaxiNumber() {return taxiNumber;}
    public void setTaxiNumber(int taxiNumber) { this.taxiNumber = taxiNumber;}

    public VehicleType getVehicletype() { return vehicletype;}
    public void setVehicletype(VehicleType vehicletype) {this.vehicletype = vehicletype;}


    @Override
    public String toString() {
        return "Vehicle \nModel " + model +
        "\nManufacturer: " + manufacturer +
        "\nYear Produced: " + yearProduced +
        "\nRegistration Number: " + registrationNumber +
        "\nTaxi Number: " + taxiNumber +
        "\nVehicle Type: " + vehicletype;
    }

}