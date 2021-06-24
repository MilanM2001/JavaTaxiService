package GUI.DispatcherOptions.ForCars;

import Cars.Car;
import Enums.VehicleAvailable;
import Enums.VehicleType;
import Main.TaxiServiceMain;
import ServiceData.TaxiService;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarsFormEdit extends JFrame{

    private JLabel lblCarID = new JLabel("Car ID");
    private JTextField txtCarID = new JTextField(20);

    private JLabel lblModel = new JLabel("Model");
    private JTextField txtModel = new JTextField(20);

    private JLabel lblManufacturer = new JLabel("Manufacturer");
    private JTextField txtManufacturer = new JTextField(20);

    private JLabel lblYearProduced = new JLabel("Year Produced");
    private JTextField txtYearProduced = new JTextField(20);

    private JLabel lblRegistrationNumber = new JLabel("Registrations");
    private JTextField txtRegistrationNumber = new JTextField(20);

    private JLabel lblTaxiNumber = new JLabel("Taxi Number");
    private JTextField txtTaxiNumber = new JTextField(20);

    private JLabel lblVehicleType = new JLabel("Vehicle Type");
    private JComboBox<VehicleType> cbVehicleType = new JComboBox<VehicleType>(VehicleType.values());

    private JLabel lblVehicleAvailable = new JLabel("Vehicle Available");
    private JComboBox<VehicleAvailable> cbVehicleAvailable = new JComboBox<VehicleAvailable>(VehicleAvailable.values());

    private JButton btnOk = new JButton("OK");
    private JButton btnCancel = new JButton("Cancel");

    private TaxiService taxiService;
    private Car car;

    public CarsFormEdit(TaxiService taxiService, Car car) {
        this.taxiService = taxiService;
        this.car = car;
        if(car == null) {
            setTitle("Adding Car");
        }else {
            setTitle("Change Information - " + car.getCarID());
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

        if(car != null) {
            FillFields();
        }
        add(lblModel);
        add(txtModel);

        add(lblManufacturer);
        add(txtManufacturer);

        add(lblYearProduced);
        add(txtYearProduced);

        add(lblRegistrationNumber);
        add(txtRegistrationNumber);

        add(lblTaxiNumber);
        add(txtTaxiNumber);

        add(lblVehicleType);
        add(cbVehicleType);

        cbVehicleAvailable.setSelectedItem(VehicleAvailable.Available);

        add(new JLabel());
        add(btnOk, "split 2");
        add(btnCancel);
    }

    private void initActions() {
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(CarsValidation()) {
                    int carID = Integer.parseInt(txtCarID.getText().trim());
                    String model = txtModel.getText().trim();
                    String manufacturer = txtManufacturer.getText().trim();
                    int yearProduced = Integer.parseInt(txtYearProduced.getText().trim());
                    int registrationNumber = Integer.parseInt(txtRegistrationNumber.getText().trim());
                    int taxiNumber = Integer.parseInt(txtTaxiNumber.getText().trim());
                    VehicleType vehicleType = (VehicleType) cbVehicleType.getSelectedItem();
                    VehicleAvailable vehicleAvailable = (VehicleAvailable) cbVehicleAvailable.getSelectedItem();

                    if(car == null) {
                        Car newCar = new Car(carID, model, manufacturer, yearProduced, registrationNumber, taxiNumber, vehicleType, false, vehicleAvailable);
                        taxiService.addCar(newCar);
                    }else {
                        car.setCarID(carID);
                        car.setModel(model);
                        car.setManufacturer(manufacturer);
                        car.setYearProduced(yearProduced);
                        car.setRegistrationNumber(registrationNumber);
                        car.setTaxiNumber(taxiNumber);
                        car.setVehicletype(vehicleType);
                        car.setVehicleAvailable(vehicleAvailable);
                    }
                    taxiService.saveCars(TaxiServiceMain.Cars_File);
                    CarsFormEdit.this.dispose();
                    CarsFormEdit.this.setVisible(false);
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarsFormEdit.this.dispose();
                CarsFormEdit.this.setVisible(false);
            }
        });
    }

    private void FillFields() {
        txtCarID.setText(String.valueOf(car.getCarID()));
        txtModel.setText(car.getModel());
        txtManufacturer.setText(car.getManufacturer());
        txtYearProduced.setText(String.valueOf(car.getYearProduced()));
        txtRegistrationNumber.setText(String.valueOf(car.getRegistrationNumber()));
        txtTaxiNumber.setText(String.valueOf(car.getTaxiNumber()));
        cbVehicleType.setSelectedItem(car.getVehicletype());
        cbVehicleAvailable.setSelectedItem(car.getVehicleAvailable());
    }

    private boolean CarsValidation() {
        boolean ok = true;
        String message = "Please correct the following mistakes:\n";

        if(txtModel.getText().trim().equals("")) {
            message += "- Model\n";
            ok = false;
        }if(txtManufacturer.getText().trim().equals("")) {
            message += "- Manufacturer\n";
            ok = false;
        }if(txtYearProduced.getText().trim().equals("")) {
            message += "- Year Produced\n";
            ok = false;
        }if(txtRegistrationNumber.getText().trim().equals("")) {
            message += "- Registration Number\n";
            ok = false;
        }if(txtTaxiNumber.getText().trim().equals("")) {
            message += "- Taxi Number\n";
            ok = false;
        }
        if(ok == false) {
            JOptionPane.showMessageDialog(null, message, "Incorrect Info", JOptionPane.WARNING_MESSAGE);
        }

        return ok;
    }
}
