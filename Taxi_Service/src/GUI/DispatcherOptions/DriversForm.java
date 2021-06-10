package GUI.DispatcherOptions;

import AllUsers.Driver;
import Enums.Gender;
import Enums.Roles;
import ServiceData.TaxiService;
import Main.TaxiServiceMain;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DriversForm extends JFrame {

    private JLabel lblUsername = new JLabel("Username");
    private JTextField txtUsername = new JTextField(20);

    private JLabel lblPassword = new JLabel("Password");
    private JPasswordField pfPassword = new JPasswordField(20);

    private JLabel lblName = new JLabel("Name");
    private JTextField txtName = new JTextField(20);

    private JLabel lblLastName = new JLabel("Last Name");
    private JTextField txtLastName = new JTextField(20);

    private JLabel lblJmbg = new JLabel("JMBG");
    private JTextField txtJmbg = new JTextField(20);

    private JLabel lblAddress = new JLabel("Address");
    private JTextField txtAddress = new JTextField(20);

    private JLabel lblPhoneNumber = new JLabel("Phone Number");
    private JTextField txtPhoneNumber = new JTextField(20);

    private JLabel lblGender = new JLabel("Gender");
    private JComboBox<Gender> cbGender = new JComboBox<Gender>(Gender.values());

    private JLabel lblID = new JLabel("ID");
    private JTextField txtID = new JTextField(20);

    private JLabel lblRoles = new JLabel("Roles");
    private JComboBox<Roles> cbRoles = new JComboBox<Roles>(Roles.values());

    private JLabel lblDriverPay = new JLabel("Driver Pay");
    private JTextField txtDriverPay = new JTextField(20);

    private JLabel lblMembershipCard = new JLabel("Membership Card");
    private JTextField txtMembershipCard = new JTextField(20);

    private JButton btnOk = new JButton("OK");
    private JButton btnCancel = new JButton("Cancel");

    private TaxiService taxiService;
    private Driver driver;

    public DriversForm(TaxiService taxiService, Driver driver) {
        this.taxiService = taxiService;
        this.driver = driver;
        if(driver == null) {
            setTitle("Adding Driver");
        }else {
            setTitle("Change Information - " + driver.getUsername());
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

        if(driver != null) {
            FillFields();
        }
        add(lblUsername);
        add(txtUsername);

        add(lblPassword);
        add(pfPassword);

        add(lblName);
        add(txtName);

        add(lblLastName);
        add(txtLastName);

        add(lblJmbg);
        add(txtJmbg);

        add(lblAddress);
        add(txtAddress);

        add(lblPhoneNumber);
        add(txtPhoneNumber);

        add(lblGender);
        add(cbGender);

        add(lblID);
        add(txtID);

        add(lblRoles);
        add(cbRoles);

        add(lblDriverPay);
        add(txtDriverPay);

        add(lblMembershipCard);
        add(txtMembershipCard);

        add(new JLabel());
        add(btnOk, "split 2");
        add(btnCancel);
    }

    private void initActions() {
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Validation()) {
                    String username = txtUsername.getText().trim();
                    String password = new String(pfPassword.getPassword()).trim();
                    String name = txtName.getText().trim();
                    String lastName = txtLastName.getText().trim();
                    String jmbg = txtJmbg.getText().trim();
                    String address = txtAddress.getText().trim();
                    int phoneNumber = Integer.parseInt(txtPhoneNumber.getText().trim());
                    Gender gender = (Gender) cbGender.getSelectedItem();
                    int id = Integer.parseInt(txtID.getText().trim());
                    Roles roles = (Roles) cbRoles.getSelectedItem();
                    double driverPay = Double.parseDouble(txtDriverPay.getText().trim());
                    int membershipCard = Integer.parseInt(txtMembershipCard.getText().trim());

                    if(driver == null) {
                        Driver newDriver = new Driver(username, password, name, lastName, jmbg, address, phoneNumber, gender, false, id, roles, driverPay, membershipCard);
                        taxiService.addDriver(newDriver);
                    }else {
                        driver.setUsername(username);
                        driver.setPassword(password);
                        driver.setName(name);
                        driver.setLastName(lastName);
                        driver.setJmbg(jmbg);
                        driver.setAddress(address);
                        driver.setPhoneNumber(phoneNumber);
                        driver.setGender(gender);
                        driver.setId(id);
                        driver.setRoles(roles);
                        driver.setDriverPay(driverPay);
                        driver.setMembershipCard(membershipCard);
                    }
                    taxiService.saveDrivers(TaxiServiceMain.Drivers_File);
                    DriversForm.this.dispose();
                    DriversForm.this.setVisible(false);
                }
            }
        });
    }

    private void FillFields() {
        txtUsername.setText(driver.getUsername());
        pfPassword.setText(driver.getPassword());
        txtName.setText(driver.getName());
        txtLastName.setText(driver.getLastName());
        txtJmbg.setText(driver.getJmbg());
        txtAddress.setText(driver.getAddress());
        txtPhoneNumber.setText(String.valueOf(driver.getPhoneNumber()));
        cbGender.setSelectedItem(driver.getGender());
        txtID.setText(String.valueOf(driver.getId()));
        cbRoles.setSelectedItem(driver.getRoles());
        txtDriverPay.setText(String.valueOf(driver.getDriverPay()));
        txtMembershipCard.setText(String.valueOf(driver.getMembershipCard()));
    }

    private boolean Validation() {
        boolean ok = true;
        String message = "Please correct the following mistakes:\n";

        if(txtUsername.getText().trim().equals("")) {
            message += "- Username\n";
            ok = false;
        }
        String password = new String(pfPassword.getPassword()).trim();
        if(password.equals("")) {
            message += "- Password\n";
            ok = false;
        }if(txtName.getText().trim().equals("")) {
            message += "- Name\n";
            ok = false;
        }if(txtLastName.getText().trim().equals("")) {
            message += "- Last Name\n";
            ok = false;
        }if(txtJmbg.getText().trim().equals("")) {
            message += "- JMBG\n";
            ok = false;
        }if(txtAddress.getText().trim().equals("")) {
            message += "- Address\n";
            ok = false;
        }if(txtPhoneNumber.getText().trim().equals("")) {
            message += "- Phone Number\n";
            ok = false;
        }if(txtID.getText().trim().equals("")) {
            message += "- ID\n";
            ok = false;
        }if(txtDriverPay.getText().trim().equals("")) {
            message += "- Pay\n";
            ok = false;
        }if(txtMembershipCard.getText().trim().equals("")) {
            message += "- Membership Card\n";
            ok = false;
        }else if(driver == null){
            String username = txtUsername.getText().trim();
            Driver found = taxiService.findDriver(username);
            if(found != null) {
                message += "- Driver with that username already exists\n";
                ok = false;
            }
        }
        if(ok == false) {
            JOptionPane.showMessageDialog(null, message, "Incorrect Info", JOptionPane.WARNING_MESSAGE);
        }

        return ok;
    }

}
