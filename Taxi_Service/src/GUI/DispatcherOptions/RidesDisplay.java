package GUI.DispatcherOptions;

import ServiceData.TaxiService;
import Main.TaxiServiceMain;
import Rides.Ride;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RidesDisplay extends JFrame {

    private JToolBar mainToolbar = new JToolBar();
    private JButton btnAdd = new JButton();
    private JButton btnEdit = new JButton();
    private JButton btnDelete = new JButton();

    private DefaultTableModel tableModel;
    private JTable RidesDisplay;

    private TaxiService taxiService;

    public RidesDisplay(TaxiService taxiService) {
        this.taxiService = taxiService;
        setTitle("Rides");
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

        String[] headings = new String[] {"Ride ID", "Order Date", "Start Address", "Destination Address", "Customer", "Driver", "KM Passed", "Duration", "Status", "Note"};
        Object[][] content = new Object[taxiService.allNotDeletedRides().size()][headings.length];

        for(int i=0; i<taxiService.allNotDeletedRides().size(); i++) {
            Ride ride = taxiService.allNotDeletedRides().get(i);
            content[i][0] = ride.getRideID();
            content[i][1] = ride.getOrderDate();
            content[i][2] = ride.getStartAddress();
            content[i][3] = ride.getDestinationAddress();
            content[i][4] = ride.getCustomerOrder();
            content[i][5] = ride.getDriverOrder();
            content[i][6] = ride.getKmPassed();
            content[i][7] = ride.getRideDuration();
            content[i][8] = ride.getRideStatus();
            content[i][9] = ride.getCustomerNote();
        }

        tableModel = new DefaultTableModel(content, headings);
        RidesDisplay = new JTable(tableModel);

        RidesDisplay.setRowSelectionAllowed(true);
        RidesDisplay.setColumnSelectionAllowed(false);
        RidesDisplay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        RidesDisplay.setDefaultEditor(Object.class, null);
        RidesDisplay.getTableHeader().setReorderingAllowed(false);

        RidesDisplay.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for(int i=0; i< headings.length; i++) {
            RidesDisplay.getColumnModel().getColumn(0).setPreferredWidth(100);
            RidesDisplay.getColumnModel().getColumn(1).setPreferredWidth(100);
            RidesDisplay.getColumnModel().getColumn(2).setPreferredWidth(100);
            RidesDisplay.getColumnModel().getColumn(3).setPreferredWidth(100);
            RidesDisplay.getColumnModel().getColumn(4).setPreferredWidth(100);
            RidesDisplay.getColumnModel().getColumn(5).setPreferredWidth(100);
            RidesDisplay.getColumnModel().getColumn(6).setPreferredWidth(100);
            RidesDisplay.getColumnModel().getColumn(7).setPreferredWidth(100);
            RidesDisplay.getColumnModel().getColumn(8).setPreferredWidth(100);
            RidesDisplay.getColumnModel().getColumn(9).setPreferredWidth(100);
        }
        JScrollPane scrollPane = new JScrollPane(RidesDisplay);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initActions() {
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = RidesDisplay.getSelectedRow();
                if(row == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a row.", "Error", JOptionPane.WARNING_MESSAGE);
                }else {
                    String rideID = tableModel.getValueAt(row, 0).toString();
                    Ride ride = taxiService.findRide(rideID);

                    int choice = JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to delete this Ride??",
                            rideID + " - Confirm Choice", JOptionPane.YES_NO_OPTION);
                    if(choice == JOptionPane.YES_OPTION) {
                        ride.setDeleted(true);
                        tableModel.removeRow(row);
                        taxiService.saveRides(TaxiServiceMain.Drivers_File);
                    }
                }
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RidesForm rf = new RidesForm(taxiService, null);
                rf.setVisible(true);
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = RidesDisplay.getSelectedRow();
                if(row == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a row.", "Error", JOptionPane.WARNING_MESSAGE);
                }else {
                    String rideID = tableModel.getValueAt(row, 0).toString();
                    Ride ride = taxiService.findRide(rideID);
                    if(ride == null) {
                        JOptionPane.showMessageDialog(null, "Couldn't find a Ride with that ID", "Error", JOptionPane.WARNING_MESSAGE);
                    }else {
                        RidesForm rf = new RidesForm(taxiService, ride);
                        rf.setVisible(true);
                    }
                }
            }
        });
    }


}
