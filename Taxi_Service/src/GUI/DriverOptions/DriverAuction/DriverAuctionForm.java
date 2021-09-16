package GUI.DriverOptions.DriverAuction;

import AllUsers.Customer;
import AllUsers.Driver;
import Enums.PetFriendly;
import Enums.RideOrderType;
import Enums.RideStatus;
import GUI.DriverOptions.OrderedRides.RidesByPhoneForm;
import Main.TaxiServiceMain;
import Rides.Offer;
import Rides.Ride;
import ServiceData.TaxiService;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DriverAuctionForm extends JFrame {

    private JLabel lblOrderID = new JLabel("Order ID");
    private JTextField txtOrderID = new JTextField(20);

    private JLabel lblMinutes = new JLabel("Minutes");
    private JTextField txtMinutes = new JTextField(20);

    private JLabel lblDateOfCreation = new JLabel("Date of Creation");
    private JTextField txtDateOfCreation = new JTextField();

    private JLabel lblRideID = new JLabel("Ride ID");
    private JTextField txtRideID = new JTextField();

    private JLabel lblDriverID = new JLabel("Driver ID");
    private JTextField txtDriverID = new JTextField();

    private JButton btnOk = new JButton("Order");
    private JButton btnCancel = new JButton("Cancel");

    private TaxiService taxiService;
    private Ride ride;
    private Driver driver;
    private Offer offer;

    public DriverAuctionForm(TaxiService taxiService, Ride ride, Driver driver) {
        this.taxiService = taxiService;
        this.ride = ride;
        this.driver = driver;
        this.offer = offer;
        if (offer == null) {
            setTitle("Enter your time");
        }
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
        setResizable(false);
        pack();
    }

    private void initGUI() {
        MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
        setLayout(layout);

        if (offer != null) {
            FillFields();
        }
        add(lblMinutes);
        add(txtMinutes);

        add(new JLabel());
        add(btnOk, "split 2");
        add(btnCancel);
    }

    private void initActions() {
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(OfferValidation()) {
                    int orderID = taxiService.generateIDOffer();
                    int minutes = Integer.parseInt(txtMinutes.getText().trim());
                    String dateOfCreation = new SimpleDateFormat("dd-MM-yyyy/HH:mm").format(new Date());
                    int rideID = ride.getRideID();
                    int driverID = driver.getId();

                    if(offer == null) {
                        Offer newOffer = new Offer(orderID, minutes, dateOfCreation, false, rideID, driverID);
                        taxiService.addOffers(newOffer);
                    }else {
                        offer.setOrderId(orderID);
                        offer.setMinutes(minutes);
                        offer.setDateOfCreation(dateOfCreation);
                        offer.getRideID();
                        offer.getDriverID();
                    }
                    taxiService.saveOffers(TaxiServiceMain.Offers_File);
                    DriverAuctionForm.this.dispose();
                    DriverAuctionForm.this.setVisible(false);
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DriverAuctionForm.this.dispose();
                DriverAuctionForm.this.setVisible(false);
            }
        });
    }

    private void FillFields() {
        txtMinutes.setText(String.valueOf(offer.getMinutes()));
    }

    private boolean OfferValidation() {
        boolean ok = true;
        String message = "Please correct the following mistakes:\n";

        if(txtMinutes.getText().trim().equals("")) {
            message += "- Minutes\n";
            ok = false;
        }
        if(ok == false) {
            JOptionPane.showMessageDialog(null, message, "Incorrect Info", JOptionPane.WARNING_MESSAGE);
        }

        return ok;
    }

}
