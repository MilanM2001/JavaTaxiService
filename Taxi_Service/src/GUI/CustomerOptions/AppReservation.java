package GUI.CustomerOptions;

import AllUsers.Customer;
import Enums.RideStatus;
import GUI.DispatcherOptions.RidesForm;
import Main.TaxiServiceMain;
import Rides.Ride;
import ServiceData.TaxiService;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppReservation extends JFrame {

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
    private JTextField txtDriverOrder = new JTextField(20);

    private JLabel lblKmPassed = new JLabel("KM Passed");
    private JTextField txtKmPassed = new JTextField(20);

    private JLabel lblRideDuration = new JLabel("Duration");
    private JTextField txtRideDuration = new JTextField(20);

    private JLabel lblRideStatus = new JLabel("Status");
    private JComboBox<RideStatus> cbRideStatus = new JComboBox<RideStatus>(RideStatus.values());

    private JLabel lblCustomerNote = new JLabel("Note");
    private JTextField txtCustomerNote = new JTextField(20);

    private JButton btnOk = new JButton("OK");
    private JButton btnCancel = new JButton("Cancel");

    private TaxiService taxiService;
    private Ride ride;
    private Customer customer;

    public AppReservation(TaxiService taxiService, Ride ride, Customer customer) {
        this.taxiService = taxiService;
        this.ride = ride;
        this.customer = customer;
        if (ride == null) {
            setTitle("App Reservation");
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

        if (ride != null) {
            FillFields();
        }
        add(lblRideID);
        add(txtRideID);

        txtOrderDate.setText("0");
        txtOrderDate.setEnabled(false);

        add(lblStartAddress);
        add(txtStartAddress);

        add(lblDestinationAddress);
        add(txtDestinationAddress);

        add(lblCustomerOrder);
        add(txtCustomerOrder);
        txtCustomerOrder.setText("");

        txtDriverOrder.setText("None");
        txtDriverOrder.setEnabled(false);

        txtKmPassed.setText("0");
        txtKmPassed.setEnabled(false);

        txtRideDuration.setText("0");
        txtRideDuration.setEnabled(false);

        cbRideStatus.setSelectedItem(RideStatus.Created_On_Wait);
        cbRideStatus.setEnabled(false);

        add(lblCustomerNote);
        add(txtCustomerNote);

        add(new JLabel());
        add(btnOk, "split 2");
        add(btnCancel);
    }

    private void initActions() {
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(RidesValidation()) {
                    String rideID = txtRideID.getText().trim();
                    double orderDate = Double.parseDouble(txtOrderDate.getText().trim());
                    String startAddress = txtStartAddress.getText().trim();
                    String destinationAddress = txtDestinationAddress.getText().trim();
                    String customerOrder = txtCustomerOrder.getText().trim();
                    String driverOrder = txtDriverOrder.getText().trim();
                    double kmPassed = Double.parseDouble(txtKmPassed.getText().trim());
                    double rideDuration = Double.parseDouble(txtRideDuration.getText().trim());
                    RideStatus rideStatus = (RideStatus) cbRideStatus.getSelectedItem();
                    String customerNote = txtCustomerNote.getText().trim();

                    if(ride == null) {
                        Ride newRide = new Ride(rideID, orderDate, startAddress, destinationAddress, customerOrder, driverOrder, kmPassed, rideDuration, rideStatus, customerNote, false);
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
                    }
                    taxiService.saveRides(TaxiServiceMain.Rides_File);
                    AppReservation.this.dispose();
                    AppReservation.this.setVisible(false);
                }
            }
        });
    }

    private void FillFields() {
        txtRideID.setText(ride.getRideID());
        txtOrderDate.setText(String.valueOf(ride.getOrderDate()));
        txtStartAddress.setText(ride.getStartAddress());
        txtDestinationAddress.setText(ride.getDestinationAddress());
        txtCustomerOrder.setText(String.valueOf(ride.getCustomerOrder()));
        txtDriverOrder.setText(String.valueOf(ride.getDriverOrder()));
        txtKmPassed.setText(String.valueOf(ride.getKmPassed()));
        txtRideDuration.setText(String.valueOf(ride.getRideDuration()));
        cbRideStatus.setSelectedItem(ride.getRideStatus());
        txtCustomerNote.setText(ride.getCustomerNote());
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
        }if(txtCustomerNote.getText().trim().equals("")) {
            message += "- Note\n";
            ok = false;

        }else if(ride == null){
            String rideID = txtRideID.getText().trim();
            Ride found = taxiService.findRide(rideID);
            if(found != null) {
                message += "- Ride with that ID already exists\n";
                ok = false;
            }
        }
        if(ok == false) {
            JOptionPane.showMessageDialog(null, message, "Incorrect Info", JOptionPane.WARNING_MESSAGE);
        }

        return ok;
    }

}