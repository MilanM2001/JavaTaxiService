package gui;

import allUsers.Driver;
import main.TaxiService;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {

    private JLabel lblGreeting = new JLabel("Welcome, please enter your login information. ");
    private JLabel lblUsername = new JLabel("Username");
    private JTextField txtUsername = new JTextField(20);
    private JLabel lblPassword = new JLabel("Password");
    private JPasswordField pfPassword = new JPasswordField(20);
    private JButton btnOk = new JButton("OK");
    private JButton btnCancel = new JButton("Cancel");

    private TaxiService taxiService;

    public LoginWindow(TaxiService taxiService) {

        this.taxiService = taxiService;
        setTitle("Login");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
        pack();

    }

    public void initGUI() {
        MigLayout mig = new MigLayout("wrap 2", "[][]", "[]10[][]10[]");
        setLayout(mig);

        add(lblGreeting, "span 2");
        add(lblUsername);
        add(txtUsername);
        add(lblPassword);
        add(pfPassword);
        add(new JLabel());
        add(btnOk, "split 2");
        add(btnCancel);

        getRootPane().setDefaultButton(btnOk);
    }

    public void initActions() {
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginWindow.this.dispose();
                LoginWindow.this.setVisible(false);
            }
        });

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText().trim();
                String password = new String(pfPassword.getPassword()).trim();

                if(username.equals("") || password.equals("")) {
                    JOptionPane.showMessageDialog(null, "You didn't fill all the required fields.", "Error", JOptionPane.WARNING_MESSAGE);
                }else {
                     Driver loggedIn = taxiService.login(username, password);
                    if(loggedIn == null) {
                        JOptionPane.showMessageDialog(null, "Incorrect Login Information.", "Error", JOptionPane.WARNING_MESSAGE);
                    }else {
                        LoginWindow.this.dispose();
                        LoginWindow.this.setVisible(false);
                        mainMenu mainM = new mainMenu(taxiService, loggedIn);
                        mainM.setVisible(true);
                    }
                }
            }
        });

    }

}


