package GUI;

import AllUsers.Driver;
import ServiceData.TaxiService;

import javax.swing.*;

public class DriverMenu extends JFrame {

    private JMenuBar mainMenu = new JMenuBar();
    private JMenu carsMenu = new JMenu("Vehicles");
    private JMenuItem carsItem = new JMenuItem("Cars");

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
        mainMenu.add(carsMenu);
        carsMenu.add(carsItem);
    }

    private void initActions() {
    }

}
