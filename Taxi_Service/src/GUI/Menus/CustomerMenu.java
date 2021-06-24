package GUI.Menus;

import AllUsers.Customer;
import GUI.CustomerOptions.AppReservation;
import GUI.CustomerOptions.PhoneReservation;
import Main.LoginWindow;
import ServiceData.TaxiService;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerMenu extends JFrame {

    private JMenuBar mainMenu = new JMenuBar();
    private JMenu reservationMenu = new JMenu("Reservations");
    private JMenuItem phoneReservationItem = new JMenuItem("Phone Reservation");
    private JMenuItem appReservationItem = new JMenuItem("App Reservation");
    private JButton logOff = new JButton("Log Out");

    private TaxiService taxiService;
    private Customer loggedIn;

    public CustomerMenu(TaxiService taxiService, Customer loggedIn) {
        this.taxiService = taxiService;
        this.loggedIn = loggedIn;
        setTitle("Customer Menu: " + loggedIn.getUsername());
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initMenu();
        initActions();
    }

    private void initMenu() {
        setJMenuBar(mainMenu);
        mainMenu.add(reservationMenu);
        reservationMenu.add(phoneReservationItem);
        reservationMenu.add(appReservationItem);
        mainMenu.add(logOff);
    }

    private void initActions() {
        appReservationItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AppReservation ar = new AppReservation(taxiService, null, null);
                ar.setVisible(true);
            }
        });

        phoneReservationItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PhoneReservation pr = new PhoneReservation(taxiService, null, null);
                pr.setVisible(true);
            }
        });

        logOff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginWindow lw = new LoginWindow(taxiService);
                lw.setVisible(true);
                CustomerMenu.this.dispose();
                CustomerMenu.this.setVisible(false);
            }
        });

    }

}
