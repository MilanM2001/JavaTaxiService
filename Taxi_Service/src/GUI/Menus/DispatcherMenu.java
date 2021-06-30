package GUI.Menus;

import AllUsers.Dispatcher;
import GUI.DispatcherOptions.ForCars.CarsDisplay;
import GUI.DispatcherOptions.ForDispatchers.DispatchersDisplay;
import GUI.DispatcherOptions.ForDrivers.DriversDisplay;
import GUI.DispatcherOptions.ForInfo.InfoDisplay;
import GUI.DispatcherOptions.ForRides.RidesByPhoneToDriversDisplay;
import GUI.DispatcherOptions.ForRides.RidesDisplay;
import GUI.DispatcherOptions.ReportStatistics.StatisticsDisplay;
import Main.LoginWindow;
import ServiceData.TaxiService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DispatcherMenu extends JFrame {

    private JMenuBar mainMenu = new JMenuBar();
    private JMenu driversMenu = new JMenu("Users");
    private JMenuItem showDriversItem = new JMenuItem("Show Drivers");
    private JMenuItem showDispatchersItem = new JMenuItem("Show Dispatchers");

    private JMenu carsMenu = new JMenu("Cars");
    private JMenuItem showCarsItem = new JMenuItem("Show Cars");

    private JMenu ridesMenu = new JMenu("Rides");
    private JMenuItem showRidesItem = new JMenuItem("Show All Rides");
    private JMenuItem showRidesByPhoneItem = new JMenuItem("Rides By Phone");

    private JMenu taxiServiceInfoMenu = new JMenu("Info");
    private JMenuItem showServiceInfo = new JMenuItem("Show Service Info");

    private JMenu reportStatistics = new JMenu("Statistics");
    private JMenuItem reportYearlyStatistics = new JMenuItem("Yearly Report");

    private JButton logOff = new JButton("LogOut");

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
        driversMenu.add(showDispatchersItem);
        mainMenu.add(carsMenu);
        carsMenu.add(showCarsItem);
        mainMenu.add(ridesMenu);
        ridesMenu.add(showRidesItem);
        ridesMenu.add(showRidesByPhoneItem);
        mainMenu.add(taxiServiceInfoMenu);
        taxiServiceInfoMenu.add(showServiceInfo);
        mainMenu.add(reportStatistics);
        reportStatistics.add(reportYearlyStatistics);
        mainMenu.add(logOff);
    }

    private void initActions() {
        showDriversItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DriversDisplay dd = new DriversDisplay(taxiService);
                dd.setVisible(true);
            }
        });

        showCarsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarsDisplay dc = new CarsDisplay(taxiService);
                dc.setVisible(true);
            }
        });

        showDispatchersItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DispatchersDisplay dd = new DispatchersDisplay(taxiService);
                dd.setVisible(true);
            }
        });

        showRidesItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RidesDisplay dd = new RidesDisplay(taxiService);
                dd.setVisible(true);
            }
        });

        showServiceInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InfoDisplay id = new InfoDisplay(taxiService);
                id.setVisible(true);
            }
        });

        logOff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginWindow lw = new LoginWindow(taxiService);
                lw.setVisible(true);
                DispatcherMenu.this.dispose();
                DispatcherMenu.this.setVisible(false);
            }
        });

        showRidesByPhoneItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RidesByPhoneToDriversDisplay rp = new RidesByPhoneToDriversDisplay(taxiService);
                rp.setVisible(true);
            }
        });

        reportYearlyStatistics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatisticsDisplay sp = new StatisticsDisplay(taxiService);
                sp.setVisible(true);
            }
        });

    }
}
