package GUI.Menus;

import AllUsers.Driver;
import GUI.DriverOptions.OrderedRides.RidesByApplicationDisplay;
import GUI.DriverOptions.OrderedRides.RidesByPhoneDisplay;
import Main.LoginWindow;
import ServiceData.TaxiService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DriverMenu extends JFrame {

    private JMenuBar mainMenu = new JMenuBar();
    private JMenu ridesMenu = new JMenu("Rides");
    private JMenuItem ridesByApplication = new JMenuItem("Application");
    private JMenuItem ridesByPhone = new JMenuItem("Phone");
    private JButton logOff = new JButton("Log Out");

    private TaxiService taxiService;
    private Driver loggedIn;

    public DriverMenu(TaxiService taxiService, Driver loggedIn) {
        this.taxiService = taxiService;
        this.loggedIn = loggedIn;
        setTitle("Driver Menu: " + loggedIn.getUsername());
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initMenu();
        initActions();
    }

    private void initMenu() {
        setJMenuBar(mainMenu);
        mainMenu.add(ridesMenu);
        ridesMenu.add(ridesByApplication);
        ridesMenu.add(ridesByPhone);
        mainMenu.add(logOff);
    }

    private void initActions() {
        logOff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginWindow lw = new LoginWindow(taxiService);
                lw.setVisible(true);
                DriverMenu.this.dispose();
                DriverMenu.this.setVisible(false);
            }
        });

        ridesByApplication.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RidesByApplicationDisplay dr = new RidesByApplicationDisplay(taxiService);
                dr.setVisible(true);
            }
        });

        ridesByPhone.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RidesByPhoneDisplay pd = new RidesByPhoneDisplay(taxiService);
                pd.setVisible(true);
            }
        });

    }

}
