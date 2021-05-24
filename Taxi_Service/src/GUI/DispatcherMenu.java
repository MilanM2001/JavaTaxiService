package GUI;

import AllUsers.Dispatcher;
import GUI.DispatcherForms.DriversDisplay;
import Main.TaxiService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DispatcherMenu extends JFrame {

    private JMenuBar mainMenu = new JMenuBar();
    private JMenu carsMenu = new JMenu("Vehicles");
    private JMenuItem carsDisplayItem = new JMenuItem("Display Vehicles");
    private JMenuItem carsSearchItem = new JMenuItem("Search Vehicles");
    private JMenu driversMenu = new JMenu("Drivers");
    private JMenuItem driversDisplayItem = new JMenuItem("Display Drivers");
    private JMenuItem driversSearchItem = new JMenuItem("Search Drivers");

    private TaxiService taxiService;
    private Dispatcher loggedIn;

    public DispatcherMenu(TaxiService taxiService, Dispatcher loggedIn) {
        this.taxiService = taxiService;
        this.loggedIn = loggedIn;
        setTitle("Dispatcher Menu: " + loggedIn.getUsername());
        setSize(500, 500);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initMenu();
        initActions();
    }

    private void initMenu() {
        setJMenuBar(mainMenu);
        mainMenu.add(carsMenu);
        carsMenu.add(carsDisplayItem);
        carsMenu.add(carsSearchItem);
        mainMenu.add(driversMenu);
        driversMenu.add(driversDisplayItem);
        driversMenu.add(driversSearchItem);
    }

    private void initActions() {
        driversDisplayItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DriversDisplay driversDisplay = new DriversDisplay(taxiService);
                driversDisplay.setVisible(true);
            }
        });

    }

}
