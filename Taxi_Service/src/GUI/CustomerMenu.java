package GUI;

import AllUsers.Customer;
import Main.TaxiService;

import javax.swing.*;

public class CustomerMenu extends JFrame {

    private JMenuBar mainMenu = new JMenuBar();
    private JMenu carsMenu = new JMenu("Vehicles");
    private JMenuItem carsItem = new JMenuItem("Cars");


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
        mainMenu.add(carsMenu);
        carsMenu.add(carsItem);
    }

    private void initActions() {
    }

}
