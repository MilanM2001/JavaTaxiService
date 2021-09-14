package GUI.DispatcherOptions.ForCars;

import Cars.Car;
import Enums.PetFriendly;
import Enums.VehicleAvailable;
import Enums.VehicleType;
import ServiceData.TaxiService;
import Main.TaxiServiceMain;
import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarsForm extends JFrame {

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

    private JLabel lblCarAge = new JLabel("Car Age");
    private JTextField txtCarAge = new JTextField(20);

    private JLabel lblPetFriendly = new JLabel("Pet Friendly");
    private JComboBox<PetFriendly> cbPetFriendly = new JComboBox<PetFriendly>(PetFriendly.values());

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

        add(lblCarAge);
        add(txtCarAge);

        add(lblPetFriendly);
        add(txtCarAge);

        add(new JLabel());
        add(btnOk, "split 2");
        add(btnCancel);
    }

    private void initActions() {
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(CarsValidation()) {
                    int carID = taxiService.generateIDCar();
                    String model = txtModel.getText().trim();
                    String manufacturer = txtManufacturer.getText().trim();
                    int yearProduced = Integer.parseInt(txtYearProduced.getText().trim());
                    int registrationNumber = Integer.parseInt(txtRegistrationNumber.getText().trim());
                    int taxiNumber = Integer.parseInt(txtTaxiNumber.getText().trim());
                    VehicleType vehicleType = (VehicleType) cbVehicleType.getSelectedItem();
                    VehicleAvailable vehicleAvailable = (VehicleAvailable) cbVehicleAvailable.getSelectedItem();
                    int carAge = Integer.parseInt(txtCarAge.getText().trim());
                    PetFriendly petFriendly = (PetFriendly) cbPetFriendly.getSelectedItem();

                    if(car == null) {
                        Car newCar = new Car(carID, model, manufacturer, yearProduced, registrationNumber, taxiNumber, vehicleType, false, vehicleAvailable, carAge, petFriendly);
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
                        car.setCarAge(carAge);
                        car.setPetFriendly(petFriendly);
                    }
                    taxiService.saveCars(TaxiServiceMain.Cars_File);
                    CarsForm.this.dispose();
                    CarsForm.this.setVisible(false);
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarsForm.this.dispose();
                CarsForm.this.setVisible(false);
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
        txtCarAge.setText(String.valueOf(car.getCarAge()));
        cbPetFriendly.setSelectedItem(car.getPetFriendly());
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
        }if(txtCarAge.getText().trim().equals("")) {
            message += "- Car Age\n";
            ok = false;
        }if(ok == false) {
            JOptionPane.showMessageDialog(null, message, "Incorrect Info", JOptionPane.WARNING_MESSAGE);
        }

        return ok;
    }

}
