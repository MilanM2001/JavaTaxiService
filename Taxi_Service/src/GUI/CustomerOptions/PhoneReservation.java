package GUI.CustomerOptions;

import AllUsers.Customer;
import Enums.RideOrderType;
import Enums.RideStatus;
import Main.TaxiServiceMain;
import Rides.Ride;
import ServiceData.TaxiService;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PhoneReservation extends JFrame {

    private JLabel lblRideID = new JLabel("Ride ID");
    private JTextField txtRideID = new JTextField(20);

    private JLabel lblOrderDate = new JLabel("Order Date");
    private JTextField txtOrderDate = new JTextField(20);

    private JLabel lblStartAddress = new JLabel("Start Address");
    private JTextField txtStartAddress = new JTextField(20);

    private JLabel lblDestinationAddress = new JLabel("Destination Address");
    private JTextField txtDestinationAddress = new JTextField(20);

    private JLabel lblCustomerOrder = new JLabel("Your Name");
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

    private JLabel lblRideOrderType = new JLabel("Order Type");
    private JComboBox<RideOrderType> cbRideOrderType = new JComboBox<RideOrderType>(RideOrderType.values());

    private JButton btnOk = new JButton("Order");
    private JButton btnCancel = new JButton("Cancel");

    private TaxiService taxiService;
    private Ride ride;
    private Customer customer;

    public PhoneReservation(TaxiService taxiService, Ride ride, Customer customer) {
        this.taxiService = taxiService;
        this.ride = ride;
        if (ride == null) {
            setTitle("Phone Reservation");
        }
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions(customer);
        setResizable(false);
        pack();
    }

    private void initGUI() {
        MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
        setLayout(layout);

        if (ride != null) {
            FillFields();
        }
        add(lblStartAddress);
        add(txtStartAddress);

        add(lblDestinationAddress);
        add(txtDestinationAddress);

        add(lblCustomerOrder);
        add(txtCustomerOrder);

        txtDriverOrder.setText("0");

        txtKmPassed.setText("0");

        txtRideDuration.setText("0");

        cbRideStatus.setSelectedItem(RideStatus.Created);

        txtCustomerNote.setText("None");

        cbRideOrderType.setSelectedItem(RideOrderType.Phone);

        add(new JLabel());
        add(btnOk, "split 2");
        add(btnCancel);
    }

    private void initActions(Customer customer) {
        this.customer = customer;
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(RidesValidation()) {
                    int rideID = taxiService.generateIDRide();
                    String orderDate = new SimpleDateFormat("dd-MM-yyyy/HH:mm").format(new Date());
                    String startAddress = txtStartAddress.getText().trim();
                    String destinationAddress = txtDestinationAddress.getText().trim();
                    String customerOrder = txtCustomerOrder.getText().trim();
                    int driverOrder = Integer.parseInt(txtDriverOrder.getText().trim());
                    double kmPassed = Double.parseDouble(txtKmPassed.getText().trim());
                    double rideDuration = Double.parseDouble(txtRideDuration.getText().trim());
                    RideStatus rideStatus = (RideStatus) cbRideStatus.getSelectedItem();
                    String customerNote = txtCustomerNote.getText().trim();
                    RideOrderType rideOrderType = (RideOrderType) cbRideOrderType.getSelectedItem();

                    if(ride == null) {
                        Ride newRide = new Ride(rideID, orderDate, startAddress, destinationAddress, customerOrder, driverOrder, kmPassed, rideDuration, rideStatus, customerNote, rideOrderType, false);
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
                        ride.setRideOrderType(rideOrderType);
                    }
                    taxiService.saveRides(TaxiServiceMain.Rides_File);
                    PhoneReservation.this.dispose();
                    PhoneReservation.this.setVisible(false);
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PhoneReservation.this.dispose();
                PhoneReservation.this.setVisible(false);
            }
        });
    }

    private void FillFields() {
        txtRideID.setText(String.valueOf(ride.getRideID()));
        txtOrderDate.setText(ride.getOrderDate());
        txtStartAddress.setText(ride.getStartAddress());
        txtDestinationAddress.setText(ride.getDestinationAddress());
        txtCustomerOrder.setText(String.valueOf(ride.getCustomerOrder()));
        txtDriverOrder.setText(String.valueOf(ride.getDriverOrder()));
        txtKmPassed.setText(String.valueOf(ride.getKmPassed()));
        txtRideDuration.setText(String.valueOf(ride.getRideDuration()));
        cbRideStatus.setSelectedItem(ride.getRideStatus());
        txtCustomerNote.setText(ride.getCustomerNote());
        cbRideOrderType.setSelectedItem(ride.getRideOrderType());
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
        }
        if(ok == false) {
            JOptionPane.showMessageDialog(null, message, "Incorrect Info", JOptionPane.WARNING_MESSAGE);
        }

        return ok;
    }


}
