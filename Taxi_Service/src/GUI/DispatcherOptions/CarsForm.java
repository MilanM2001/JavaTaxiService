package GUI.DispatcherOptions;

import Cars.Car;
import Enums.VehicleType;
import ServiceData.TaxiService;
import Main.TaxiServiceMain;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarsForm extends JFrame {
    private JLabel lblIDCode = new JLabel("ID Code");
    private JTextField txtIDCode = new JTextField(20);

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

    private JButton btnOk = new JButton("OK");
    private JButton btnCancel = new JButton("Cancel");

    private TaxiService taxiService;
    private Car car;

    public CarsForm(TaxiService taxiService, Car car) {
        this.taxiService = taxiService;
        this.car = car;
        if(car == null) {
            setTitle("Adding Car");
        }else {
            setTitle("Change Information - " + car.getIDCode());
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
        add(lblIDCode);
        add(txtIDCode);

        add(lblCarID);
        add(txtCarID);

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

        add(new JLabel());
        add(btnOk, "split 2");
        add(btnCancel);
    }

    private void initActions() {
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(CarsValidation()) {
                    String IDCode = txtIDCode.getText().trim();
                    int carID = Integer.parseInt(txtCarID.getText().trim());
                    String model = txtModel.getText().trim();
                    String manufacturer = txtManufacturer.getText().trim();
                    int yearProduced = Integer.parseInt(txtYearProduced.getText().trim());
                    int registrationNumber = Integer.parseInt(txtRegistrationNumber.getText().trim());
                    int taxiNumber = Integer.parseInt(txtTaxiNumber.getText().trim());
                    VehicleType vehicleType = (VehicleType) cbVehicleType.getSelectedItem();

                    if(car == null) {
                        Car newCar = new Car(IDCode, carID, model, manufacturer, yearProduced, registrationNumber, taxiNumber, vehicleType, false);
                        taxiService.addCar(newCar);
                    }else {
                        car.setIDCode(IDCode);
                        car.setCarID(carID);
                        car.setModel(model);
                        car.setManufacturer(manufacturer);
                        car.setYearProduced(yearProduced);
                        car.setRegistrationNumber(registrationNumber);
                        car.setTaxiNumber(taxiNumber);
                        car.setVehicletype(vehicleType);
                    }
                    taxiService.saveCars(TaxiServiceMain.Cars_File);
                    CarsForm.this.dispose();
                    CarsForm.this.setVisible(false);
                }
            }
        });
    }

    private void FillFields() {
        txtIDCode.setText(car.getIDCode());
        txtCarID.setText(String.valueOf(car.getCarID()));
        txtModel.setText(car.getModel());
        txtManufacturer.setText(car.getManufacturer());
        txtYearProduced.setText(String.valueOf(car.getYearProduced()));
        txtRegistrationNumber.setText(String.valueOf(car.getRegistrationNumber()));
        txtTaxiNumber.setText(String.valueOf(car.getTaxiNumber()));
        cbVehicleType.setSelectedItem(car.getVehicletype());
    }

    private boolean CarsValidation() {
        boolean ok = true;
        String message = "Please correct the following mistakes:\n";

        if(txtIDCode.getText().trim().equals("")) {
            message += "- ID Code\n";
            ok = false;
        }
        if(txtCarID.getText().trim().equals("")) {
            message += "- ID\n";
            ok = false;
        }if(txtModel.getText().trim().equals("")) {
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
        }else if(car == null){
            String IDCode = txtIDCode.getText().trim();
            Car found = taxiService.findCar(IDCode);
            if(found != null) {
                message += "- Car with that ID already exists\n";
                ok = false;
            }
        }
        if(ok == false) {
            JOptionPane.showMessageDialog(null, message, "Incorrect Info", JOptionPane.WARNING_MESSAGE);
        }

        return ok;
    }

}
