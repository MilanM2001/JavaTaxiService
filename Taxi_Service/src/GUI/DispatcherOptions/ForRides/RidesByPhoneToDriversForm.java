package GUI.DispatcherOptions.ForRides;

import AllUsers.Driver;
import Cars.Car;
import Enums.PetFriendly;
import Enums.RideOrderType;
import Enums.RideStatus;
import GUI.DriverOptions.RidesByApplicationForm;
import Main.TaxiServiceMain;
import Rides.Ride;
import ServiceData.TaxiService;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RidesByPhoneToDriversForm extends JFrame {

    private ArrayList<Driver> driverList;

    private JLabel lblRideID = new JLabel("Ride ID");
    private JTextField txtRideID = new JTextField(20);

    private JLabel lblOrderDate = new JLabel("Order Date");
    private JTextField txtOrderDate = new JTextField(20);

    private JLabel lblStartAddress = new JLabel("Start Address");
    private JTextField txtStartAddress = new JTextField(20);

    private JLabel lblDestinationAddress = new JLabel("Destination Address");
    private JTextField txtDestinationAddress = new JTextField(20);

    private JLabel lblCustomerOrder = new JLabel("Customer");
    private JTextField txtCustomerOrder = new JTextField(20);

    private JLabel lblDriverOrder = new JLabel("Driver");
    private JComboBox<Driver> cbDriverOrder = new JComboBox<Driver>();

    private JLabel lblKmPassed = new JLabel("KM Passed");
    private JTextField txtKmPassed = new JTextField(20);

    private JLabel lblRideDuration = new JLabel("Duration");
    private JTextField txtRideDuration = new JTextField(20);

    private JLabel lblRideStatus = new JLabel("Status");
    private JComboBox<RideStatus> cbRideStatus = new JComboBox<RideStatus>(RideStatus.values());

    private JLabel lblCustomerNote = new JLabel("Note");
    private JTextField txtCustomerNote = new JTextField(20);

    private JLabel lblRideOrderType = new JLabel("Order Type");
    private JComboBox<RideOrderType> cbRideOrderType = new JComboBox<RideOrderType>(RideOrderType.values());

    private JLabel lblCarAgeOrder = new JLabel("Car Age");
    private JTextField txtCarAgeOrder = new JTextField(20);

    private JLabel lblPetFriendly = new JLabel("Pet Friendly");
    private JComboBox<PetFriendly> cbPetFriendly = new JComboBox<PetFriendly>(PetFriendly.values());

    private JButton btnOk = new JButton("OK");
    private JButton btnCancel = new JButton("Cancel");

    private TaxiService taxiService;
    private Ride ride;
    private Driver driver;

    public RidesByPhoneToDriversForm(TaxiService taxiService, Ride ride) {
        this.taxiService = taxiService;
        this.driverList = this.taxiService.getDrivers();
        for (int i = 0; i < this.driverList.size(); i++) {
            this.cbDriverOrder.addItem(driverList.get(i));
        }
        this.driver = driver;
        this.ride = ride;
        if(ride == null) {
            setTitle("Adding Ride");
        }else {
            setTitle("Change Information - " + ride.getRideID());
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

        if(ride != null) {
            FillFields();
        }
        add(lblStartAddress);
        add(txtStartAddress);
        txtStartAddress.setEnabled(false);

        add(lblDestinationAddress);
        add(txtDestinationAddress);
        txtDestinationAddress.setEnabled(false);

        add(lblCustomerOrder);
        add(txtCustomerOrder);
        txtCustomerOrder.setEnabled(false);

        add(lblDriverOrder);
        add(cbDriverOrder);

        txtKmPassed.setEnabled(false);

        txtRideDuration.setEnabled(false);

        add(lblRideStatus);
        add(cbRideStatus);
        cbRideStatus.setSelectedItem(RideStatus.Given);
        cbRideStatus.setEnabled(false);

        add(lblCustomerNote);
        add(txtCustomerNote);
        txtCustomerNote.setEnabled(false);

        add(lblRideOrderType);
        add(cbRideOrderType);
        cbRideOrderType.setEnabled(false);

        add(lblCarAgeOrder);
        add(txtCarAgeOrder);
        txtCarAgeOrder.setEnabled(false);

        add(lblPetFriendly);
        add(cbPetFriendly);
        cbPetFriendly.setEnabled(false);

        add(new JLabel());
        add(btnOk, "split 2");
        add(btnCancel);
    }

    private void initActions() {
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(RidesValidation()) {
                    int rideID = Integer.parseInt(txtRideID.getText().trim());
                    String orderDate = txtOrderDate.getText().trim();
                    String startAddress = txtStartAddress.getText().trim();
                    String destinationAddress = txtDestinationAddress.getText().trim();
                    String customerOrder = txtCustomerOrder.getText().trim();
                    int driverOrder = ((Driver) cbDriverOrder.getSelectedItem()).getId();
                    double kmPassed = Double.parseDouble(txtKmPassed.getText().trim());
                    double rideDuration = Double.parseDouble(txtRideDuration.getText().trim());
                    RideStatus rideStatus = (RideStatus) cbRideStatus.getSelectedItem();
                    String customerNote = txtCustomerNote.getText().trim();
                    RideOrderType rideOrderType = (RideOrderType) cbRideOrderType.getSelectedItem();
                    int carAgeOrder = Integer.parseInt(txtCarAgeOrder.getText().trim());
                    PetFriendly petFriendly = (PetFriendly) cbPetFriendly.getSelectedItem();

                    if(ride == null) {
                        Ride newRide = new Ride(rideID, orderDate, startAddress, destinationAddress, customerOrder, driverOrder, kmPassed, rideDuration, rideStatus, customerNote, rideOrderType, false, carAgeOrder, petFriendly);
                        taxiService.addRide(newRide);
                    }else {
                        ride.setRideID(rideID);
                        ride.setOrderDate(orderDate);
                        ride.setStartAddress(startAddress);
                        ride.setDestinationAddress(destinationAddress);
                        ride.setCustomerOrder(customerOrder);
                        ride.setDriverOrder(driverOrder);
                        ride.setKmPassed(kmPassed);
                        ride.setRideDuration(rideDuration);
                        ride.setRideStatus(rideStatus);
                        ride.setCustomerNote(customerNote);
                        ride.setCarAgeOrder(carAgeOrder);
                        ride.setPetFriendly(petFriendly);
                    }
                    taxiService.saveRides(TaxiServiceMain.Rides_File);
                    RidesByPhoneToDriversForm.this.dispose();
                    RidesByPhoneToDriversForm.this.setVisible(false);
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RidesByPhoneToDriversForm.this.dispose();
                RidesByPhoneToDriversForm.this.setVisible(false);
            }
        });
    }

    private void FillFields() {
        txtRideID.setText(String.valueOf(ride.getRideID()));
        txtOrderDate.setText(ride.getOrderDate());
        txtStartAddress.setText(ride.getStartAddress());
        txtDestinationAddress.setText(ride.getDestinationAddress());
        txtCustomerOrder.setText(String.valueOf(ride.getCustomerOrder()));
        cbDriverOrder.setSelectedItem(ride.getDriverOrder());
        txtKmPassed.setText(String.valueOf(ride.getKmPassed()));
        txtRideDuration.setText(String.valueOf(ride.getRideDuration()));
        cbRideStatus.setSelectedItem(ride.getRideStatus());
        txtCustomerNote.setText(ride.getCustomerNote());
        txtCarAgeOrder.setText(String.valueOf(ride.getCarAgeOrder()));
        cbPetFriendly.setSelectedItem(ride.getPetFriendly());
    }

    private boolean RidesValidation() {
        boolean ok = true;
        String message = "Please correct the following mistakes:\n";

        if(txtStartAddress.getText().trim().equals("")) {
            message += "- Start Address\n";
            ok = false;
        }if(txtDestinationAddress.getText().trim().equals("")) {
            message += "- Destination Address\n";
            ok = false;
        }if(txtCustomerOrder.getText().trim().equals("")) {
            message += "- Customer\n";
            ok = false;
        }if(txtKmPassed.getText().trim().equals("")) {
            message += "- KM Passed\n";
            ok = false;
        }if(txtRideDuration.getText().trim().equals("")) {
            message += "- Ride Duration\n";
            ok = false;
        }
        if(ok == false) {
            JOptionPane.showMessageDialog(null, message, "Incorrect Info", JOptionPane.WARNING_MESSAGE);
        }

        return ok;
    }

}
