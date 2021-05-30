package GUI.DispatcherOptions;

import Enums.RideStatus;
import Main.TaxiService;
import Main.TaxiServiceMain;
import Rides.Ride;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RidesForm extends JFrame {

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

    private JButton btnOk = new JButton("OK");
    private JButton btnCanel = new JButton("Cancel");

    private TaxiService taxiService;
    private Ride ride;

    public RidesForm(TaxiService taxiService, Ride ride) {
        this.taxiService = taxiService;
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
        add(lblRideID);
        add(txtRideID);

        add(lblOrderDate);
        add(txtOrderDate);

        add(lblStartAddress);
        add(txtStartAddress);

        add(lblDestinationAddress);
        add(txtDestinationAddress);

        add(lblCustomerOrder);
        add(txtCustomerOrder);

        add(lblDriverOrder);
        add(txtDriverOrder);

        add(lblKmPassed);
        add(txtKmPassed);

        add(lblRideDuration);
        add(txtRideDuration);

        add(lblRideStatus);
        add(cbRideStatus);

        add(new JLabel());
        add(btnOk, "split 2");
        add(btnCanel);
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

                    if(ride == null) {
                        Ride newRide = new Ride(rideID, orderDate, startAddress, destinationAddress, customerOrder, driverOrder, kmPassed, rideDuration, rideStatus, false);
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
                    }
                    taxiService.saveRides(TaxiServiceMain.Rides_File);
                    RidesForm.this.dispose();
                    RidesForm.this.setVisible(false);
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
    }

    private boolean RidesValidation() {
        boolean ok = true;
        String message = "Please correct the following mistakes:\n";

        if(txtRideID.getText().trim().equals("")) {
            message += "- Ride ID\n";
            ok = false;
        }
        if(txtOrderDate.getText().trim().equals("")) {
            message += "- Order Date\n";
            ok = false;
        }if(txtStartAddress.getText().trim().equals("")) {
            message += "- Start Address\n";
            ok = false;
        }if(txtDestinationAddress.getText().trim().equals("")) {
            message += "- Destination Address\n";
            ok = false;
        }if(txtCustomerOrder.getText().trim().equals("")) {
            message += "- Customer\n";
            ok = false;
        }if(txtDriverOrder.getText().trim().equals("")) {
            message += "- Driver\n";
            ok = false;
        }if(txtKmPassed.getText().trim().equals("")) {
            message += "- KM Passed\n";
            ok = false;
        }if(txtRideDuration.getText().trim().equals("")) {
            message += "- Ride Duration\n";
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
