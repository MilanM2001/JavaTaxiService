package Cars;


import Enums.PetFriendly;
import Enums.VehicleAvailable;
import Enums.VehicleType;

public class Car {

    private int carID;
    private String model;
    private String manufacturer;
    private int yearProduced;
    private int registrationNumber;
    private int taxiNumber;
    private VehicleType vehicletype;
    private boolean deleted;
    private VehicleAvailable vehicleAvailable;
    private int carAge;
    private PetFriendly petFriendly;

    public Car() {
        this.carID = 0;
        this.model = "";
        this.manufacturer = "";
        this.yearProduced = 0;
        this.registrationNumber = 0;
        this.taxiNumber = 0;
        this.vehicletype = VehicleType.Passenger;
        this.deleted = false;
        this.vehicleAvailable = VehicleAvailable.Available;
        this.carAge = 0;
        this.petFriendly = PetFriendly.Yes;
    }

    public Car(int carID, String model, String manufacturer, int yearProduced, int registrationNumber, int taxiNumber, VehicleType vehicletype, boolean deleted, VehicleAvailable vehicleAvailable, int carAge, PetFriendly petFriendly) {
        super();
        this.carID = carID;
        this.model = model;
        this.manufacturer = manufacturer;
        this.yearProduced = yearProduced;
        this.registrationNumber = registrationNumber;
        this.taxiNumber = taxiNumber;
        this.vehicletype = vehicletype;
        this.deleted = deleted;
        this.vehicleAvailable = vehicleAvailable;
        this.carAge = carAge;
        this.petFriendly = petFriendly;
    }

    public int getCarID() {return carID;}
    public void setCarID(int carID) {this.carID = carID;}

    public String getModel() {return model;}
    public void setModel(String model) {this.model = model;}

    public String getManufacturer() {return manufacturer;}
    public void setManufacturer(String manufacturer) {this.manufacturer = manufacturer;}

    public int getYearProduced() {return yearProduced;}
    public void setYearProduced(int yearProduced) {this.yearProduced = yearProduced;}

    public int getRegistrationNumber() {return registrationNumber;}
    public void setRegistrationNumber(int registrationNumber) {this.registrationNumber = registrationNumber;}

    public int getTaxiNumber() {return taxiNumber;}
    public void setTaxiNumber(int taxiNumber) {this.taxiNumber = taxiNumber;}

    public VehicleType getVehicletype() { return vehicletype;}
    public void setVehicletype(VehicleType vehicletype) {this.vehicletype = vehicletype;}

    public boolean isDeleted() {return deleted;}
    public void setDeleted(boolean deleted) {this.deleted = deleted;}

    public VehicleAvailable getVehicleAvailable() {return vehicleAvailable;}
    public void setVehicleAvailable(VehicleAvailable vehicleAvailable) {this.vehicleAvailable = vehicleAvailable;}

    public int getCarAge() {return carAge;}
    public void setCarAge(int carAge) {this.carAge = carAge;}

    public PetFriendly getPetFriendly() {return petFriendly;}
    public void setPetFriendly(PetFriendly petFriendly) {this.petFriendly = petFriendly;}

    @Override
    public String toString() {
        return "Vehicle \nCarID: " + carID +
        "\nModel: " + model +
        "\nManufacturer: " + manufacturer +
        "\nYear Produced: " + yearProduced +
        "\nRegistration Number: " + registrationNumber +
        "\nTaxi Number: " + taxiNumber +
        "\nVehicle Type: " + vehicletype +
        "\nDeleted: " + deleted +
        "\nVehicle Available: " + vehicleAvailable +
        "\nCar Age: " + carAge +
        "\nPet Friendly: " + petFriendly;
    }

}