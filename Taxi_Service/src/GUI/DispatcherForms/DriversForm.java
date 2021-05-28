package GUI.DispatcherForms;

import AllUsers.Driver;
import Enums.Gender;
import Enums.Roles;
import Main.TaxiService;
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
    private JButton btnCanel = new JButton("Cancel");

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
        add(btnCanel);
    }

    private void initActions() {
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Validation()) {
                    String username = txtUsername.getText().trim();
                    String password = new String(pfPassword.getPassword()).trim();
                    String prezime = txtPrezime.getText().trim();
                    String korisnickoIme = txtKorisnickoIme.getText().trim();
                    Pol pol = (Pol)cbPol.getSelectedItem();

                    if(prodavac == null) { // DODAVANJE:
                        Prodavac novi = new Prodavac(ime, prezime, pol, korisnickoIme, sifra, false);
                        prodavnica.dodajProdavca(novi);
                    }else { // IZMENA:
                        prodavac.setIme(ime);
                        prodavac.setPrezime(prezime);
                        prodavac.setKorisnickoIme(korisnickoIme);
                        prodavac.setLozinka(sifra);
                        prodavac.setPol(pol);
                    }
                    prodavnica.snimiZaposlene(ProdavnicaMain.PRODAVCI_FAJL);
                    ProdavciForma.this.dispose();
                    ProdavciForma.this.setVisible(false);
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
        String message = "Molimo popravite sledece greske u unosu:\n";

        if(txtIme.getText().trim().equals("")) {
            poruka += "- Unesite ime\n";
            ok = false;
        }
        if(txtPrezime.getText().trim().equals("")) {
            poruka += "- Unesite prezime\n";
            ok = false;
        }
        if(txtKorisnickoIme.getText().trim().equals("")) {
            poruka += "- Unesite korisnicko ime\n";
            ok = false;
        }else if(prodavac == null){
            String korisnickoIme = txtKorisnickoIme.getText().trim();
            Prodavac pronadjeni = prodavnica.nadjiProdavca(korisnickoIme);
            if(pronadjeni != null) {
                poruka += "- Prodavac sa tim korisnickim imenom vec postoji\n";
                ok = false;
            }
        }

        String sifra = new String(pfSifra.getPassword()).trim();
        if(sifra.equals("")) {
            poruka += "- Unesite sifru\n";
            ok = false;
        }

        if(ok == false) {
            JOptionPane.showMessageDialog(null, poruka, "Neispravni podaci", JOptionPane.WARNING_MESSAGE);
        }

        return ok;
    }

}
