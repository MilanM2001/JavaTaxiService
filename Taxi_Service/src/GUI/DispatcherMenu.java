package GUI;

import AllUsers.Dispatcher;
import GUI.DispatcherUtils.DisplayCars;
import GUI.DispatcherUtils.DisplayDispatchers;
import GUI.DispatcherUtils.DisplayDrivers;
import Main.TaxiService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DispatcherMenu extends JFrame {

    private JMenuBar mainMenu = new JMenuBar();
    private JMenu driversMenu = new JMenu("Users");
    private JMenuItem showDriversItem = new JMenuItem("Show Drivers");
    private JMenuItem searchDriversItem = new JMenuItem("Search Drivers");
    private JMenuItem showDispatchersItem = new JMenuItem("Show Dispatchers");
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
        driversMenu.add(showDispatchersItem);
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

        showCarsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayCars dc = new DisplayCars(taxiService);
                dc.setVisible(true);
            }
        });

        showDispatchersItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayDispatchers dd = new DisplayDispatchers(taxiService);
                dd.setVisible(true);
            }
        });
//
//        knjigeItem.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                KnjigeProzor kp = new KnjigeProzor(prodavnica);
//                kp.setVisible(true);
//            }
//        });
    }

}
