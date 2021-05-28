package GUI;

import AllUsers.Dispatcher;
import GUI.DispatcherForms.DisplayDrivers;
import Main.TaxiService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DispatcherMenu extends JFrame {

    private JMenuBar mainMenu = new JMenuBar();
    private JMenu driversMenu = new JMenu("Drivers");
    private JMenuItem showDriversItem = new JMenuItem("Show Drivers");
    private JMenuItem searchDriversItem = new JMenuItem("Search Drivers");
    private JMenu carsMenu = new JMenu("Cars");
    private JMenuItem showCarsItem = new JMenuItem("Show Cars");
    private JMenuItem searchCarsItem = new JMenuItem("Search Cars");

    private TaxiService taxiService;
    private Dispatcher loggedIn;

    public DispatcherMenu(TaxiService taxiService, Dispatcher loggedIn) {
        this.taxiService = taxiService;
        this.loggedIn = loggedIn;
        setTitle("Dispatcher: " + loggedIn.getUsername());
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initMenu();
        initActions();
    }

    private void initMenu() {
        setJMenuBar(mainMenu);
        mainMenu.add(driversMenu);
        driversMenu.add(showDriversItem);
        driversMenu.add(searchDriversItem);
        mainMenu.add(carsMenu);
        carsMenu.add(showCarsItem);
        carsMenu.add(searchCarsItem);
    }

    private void initActions() {
        showDriversItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayDrivers dd = new DisplayDrivers(taxiService);
                dd.setVisible(true);
            }
        });

        kompozicijeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KompozicijeProzor kp = new KompozicijeProzor(prodavnica);
                kp.setVisible(true);
            }
        });

        diskoviItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DiskoviProzor dp = new DiskoviProzor(prodavnica);
                dp.setVisible(true);
            }
        });

        knjigeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                KnjigeProzor kp = new KnjigeProzor(prodavnica);
                kp.setVisible(true);
            }
        });
    }

}
