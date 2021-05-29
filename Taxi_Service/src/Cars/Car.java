package Cars;


import Enums.VehicleType;

public class Car {

    private String IDCode;
    private int carID;
    private String model;
    private String manufacturer;
    private int yearProduced;
    private int registrationNumber;
    private int taxiNumber;
    private VehicleType vehicletype;
    private boolean deleted;

    public Car() {

        this.IDCode = "";
        this.carID = 0;
        this.model = "";
        this.manufacturer = "";
        this.yearProduced = 0;
        this.registrationNumber = 0;
        this.taxiNumber = 0;
        this.vehicletype = VehicleType.Passenger;
        this.deleted = false;

    }

    public Car(String IDCode, int carID, String model, String manufacturer, int yearProduced, int registrationNumber, int taxiNumber, VehicleType vehicletype, boolean deleted) {

        super();
        this.IDCode = IDCode;
        this.carID = carID;
        this.model = model;
        this.manufacturer = manufacturer;
        this.yearProduced = yearProduced;
        this.registrationNumber = registrationNumber;
        this.taxiNumber = taxiNumber;
        this.vehicletype = vehicletype;
        this.deleted = deleted;

    }

    public String getIDCode() {return IDCode;}
    public void setIDCode(String IDCode) { this.IDCode = IDCode; }

    public int getCarID() {return carID;}
    public void setCarID(int carID) { this.carID = carID; }

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

    public boolean isDeleted() {
        return deleted;
    }
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }


    @Override
    public String toString() {
        return "Vehicle \nID Code: " + IDCode +
        "\nCar ID: " + carID +
        "\nModel: " + model +
        "\nManufacturer: " + manufacturer +
        "\nYear Produced: " + yearProduced +
        "\nRegistration Number: " + registrationNumber +
        "\nTaxi Number: " + taxiNumber +
        "\nVehicle Type: " + vehicletype +
        "\nDeleted: " + deleted;
    }

}