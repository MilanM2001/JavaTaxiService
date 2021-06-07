package ServiceData;

public class TaxiServiceInfo {
    private int PIB;
    private String TaxiServiceName;
    private String TaxiServiceAddress;
    private double TaxiServiceStartingPrice;
    private double TaxiServicePricePerKM;
    private boolean deleted;

    public TaxiServiceInfo() {
        this.PIB = 0;
        this.TaxiServiceName = "";
        this.TaxiServiceAddress = "";
        this.TaxiServiceStartingPrice = 0;
        this.TaxiServicePricePerKM = 0;
        this.deleted = false;
    }

    public TaxiServiceInfo(int PIB, String TaxiServiceName, String TaxiServiceAddress, double TaxiServiceStartingPrice, double TaxiServicePricePerKM, boolean deleted) {
        super();
        this.PIB = PIB;
        this.TaxiServiceName = TaxiServiceName;
        this.TaxiServiceAddress = TaxiServiceAddress;
        this.TaxiServiceStartingPrice = TaxiServiceStartingPrice;
        this.TaxiServicePricePerKM = TaxiServicePricePerKM;
        this.deleted = deleted;
    }

    public int getPIB() {return PIB;}
    public void setPIB(int PIB) {this.PIB = PIB;}

    public String getTaxiServiceName() {return TaxiServiceName;}
    public void setTaxiServiceName(String taxiServiceName) {this.TaxiServiceName = taxiServiceName;}

    public String getTaxiServiceAddress() {return TaxiServiceAddress;}
    public void setTaxiServiceAddress(String taxiServiceAddress) {this.TaxiServiceAddress = taxiServiceAddress;}

    public double getTaxiServiceStartingPrice() {return TaxiServiceStartingPrice;}
    public void setTaxiServiceStartingPrice(double taxiServiceStartingPrice) {this.TaxiServiceStartingPrice = taxiServiceStartingPrice;}

    public double getTaxiServicePricePerKM() {return TaxiServicePricePerKM;}
    public void setTaxiServicePricePerKM(double taxiServicePricePerKM) {this.TaxiServicePricePerKM = taxiServicePricePerKM;}

    public boolean isDeleted() {
        return deleted;
    }
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Taxi Service Info \nPIB: " + PIB +
                "\nTaxi Service Name: " + TaxiServiceName +
                "\nTaxi Service Address: " + TaxiServiceAddress +
                "\nStarting Price: " + TaxiServiceStartingPrice +
                "\nPrice Per KM: " + TaxiServicePricePerKM;
    }
}
