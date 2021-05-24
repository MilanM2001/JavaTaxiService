package GUI.DispatcherForms;

import AllUsers.Driver;
import Main.TaxiService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DriversDisplay extends JFrame {

    private JToolBar mainToolbar = new JToolBar();
    private JButton btnAdd = new JButton();
    private JButton btnEdit = new JButton();
    private JButton btnDelete = new JButton();

    private DefaultTableModel tableModel;
    private JTable driversTable;

    private TaxiService taxiService;

    public DriversDisplay(TaxiService taxiService) {
        this.taxiService = taxiService;
        setTitle("Drivers");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
    }

    private void initGUI() {
        ImageIcon addIcon = new ImageIcon(getClass().getResource("/images/add.gif"));
        btnAdd.setIcon(addIcon);
        ImageIcon editIcon = new ImageIcon(getClass().getResource("/images/edit.gif"));
        btnEdit.setIcon(editIcon);
        ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/images/remove.gif"));
        btnDelete.setIcon(deleteIcon);

        mainToolbar.add(btnAdd);
        mainToolbar.add(btnEdit);
        mainToolbar.add(btnDelete);
        add(mainToolbar, BorderLayout.NORTH);

        String[] headers = new String[] {"Name", "Last Name", "Gender", "Username", "Password"};
        Object[][] content = new Object[taxiService.allNotDeletedDrivers().size()][headers.length];

        for(int i=0; i<taxiService.allNotDeletedDrivers().size(); i++) {
            Driver driver = taxiService.allNotDeletedDrivers().get(i);
            content[i][0] = driver.getName();
            content[i][1] = driver.getLastName();
            content[i][2] = driver.getGender();
            content[i][3] = driver.getUsername();
            content[i][4] = driver.getPassword();
        }

        tableModel = new DefaultTableModel(content, headers);
        driversTable = new JTable(tableModel);

        driversTable.setRowSelectionAllowed(true);
        driversTable.setColumnSelectionAllowed(false);
        driversTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        driversTable.setDefaultEditor(Object.class, null);
        driversTable.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(driversTable);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initActions() {

    }
}
