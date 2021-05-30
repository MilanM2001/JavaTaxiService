package GUI.DispatcherOptions;

import AllUsers.Dispatcher;
import Enums.Department;
import Enums.Gender;
import Enums.Roles;
import Main.TaxiService;
import Main.TaxiServiceMain;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DispatchersForm extends JFrame {

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

    private JLabel lblDispatcherPay = new JLabel("Dispatcher Pay");
    private JTextField txtDispatcherPay = new JTextField(20);

    private JLabel lblPhoneLine = new JLabel("Phone Line");
    private JTextField txtPhoneline = new JTextField(20);

    private JLabel lblDepartment = new JLabel("Department");
    private JComboBox<Department> cbDepartment = new JComboBox<Department>(Department.values());

    private JButton btnOk = new JButton("OK");
    private JButton btnCanel = new JButton("Cancel");

    private TaxiService taxiService;
    private Dispatcher dispatcher;

    public DispatchersForm(TaxiService taxiService, Dispatcher dispatcher) {
        this.taxiService = taxiService;
        this.dispatcher = dispatcher;
        if(dispatcher == null) {
            setTitle("Adding Dispatcher");
        }else {
            setTitle("Change Information - " + dispatcher.getUsername());
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

        if(dispatcher != null) {
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

        add(lblDispatcherPay);
        add(txtDispatcherPay);

        add(lblPhoneLine);
        add(txtPhoneline);

        add(lblGender);
        add(cbGender);

        add(new JLabel());
        add(btnOk, "split 2");
        add(btnCanel);
    }

    private void initActions() {
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(DispatcherValidation()) {
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
                    double dispatcherPay = Double.parseDouble(txtDispatcherPay.getText().trim());
                    int phoneLine = Integer.parseInt(txtPhoneline.getText().trim());
                    Department department = (Department) cbDepartment.getSelectedItem();

                    if(dispatcher == null) {
                        Dispatcher newDispatcher = new Dispatcher(username, password, name, lastName, jmbg, address, phoneNumber, gender, false, id, roles, dispatcherPay, phoneLine, department);
                        taxiService.addDispatcher(newDispatcher);
                    }else {
                        dispatcher.setUsername(username);
                        dispatcher.setPassword(password);
                        dispatcher.setName(name);
                        dispatcher.setLastName(lastName);
                        dispatcher.setJmbg(jmbg);
                        dispatcher.setAddress(address);
                        dispatcher.setPhoneNumber(phoneNumber);
                        dispatcher.setGender(gender);
                        dispatcher.setId(id);
                        dispatcher.setRoles(roles);
                        dispatcher.setDispatcherPay(dispatcherPay);
                        dispatcher.setPhoneLine(phoneLine);
                        dispatcher.setDepartment(department);
                    }
                    taxiService.saveDispatchers(TaxiServiceMain.Dispatchers_File);
                    DispatchersForm.this.dispose();
                    DispatchersForm.this.setVisible(false);
                }
            }
        });
    }

    private void FillFields() {
        txtUsername.setText(dispatcher.getUsername());
        pfPassword.setText(dispatcher.getPassword());
        txtName.setText(dispatcher.getName());
        txtLastName.setText(dispatcher.getLastName());
        txtJmbg.setText(dispatcher.getJmbg());
        txtAddress.setText(dispatcher.getAddress());
        txtPhoneNumber.setText(String.valueOf(dispatcher.getPhoneNumber()));
        cbGender.setSelectedItem(dispatcher.getGender());
        txtID.setText(String.valueOf(dispatcher.getId()));
        cbRoles.setSelectedItem(dispatcher.getRoles());
        txtDispatcherPay.setText(String.valueOf(dispatcher.getDispatcherPay()));
        txtPhoneline.setText(String.valueOf(dispatcher.getPhoneLine()));
        cbDepartment.setSelectedItem(dispatcher.getDepartment());
    }

    private boolean DispatcherValidation() {
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
        }if(txtDispatcherPay.getText().trim().equals("")) {
            message += "- Pay\n";
            ok = false;
        }if(txtPhoneline.getText().trim().equals("")) {
            message += "- Phone Line\n";
            ok = false;
        }else if(dispatcher == null){
            String username = txtUsername.getText().trim();
            Dispatcher found = taxiService.findDispatcher(username);
            if(found != null) {
                message += "- Dispatcher with that username already exists\n";
                ok = false;
            }
        }
        if(ok == false) {
            JOptionPane.showMessageDialog(null, message, "Incorrect Info", JOptionPane.WARNING_MESSAGE);
        }

        return ok;
    }

}
