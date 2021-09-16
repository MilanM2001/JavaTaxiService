package GUI.DriverOptions.OrderedRides;

import Enums.RideStatus;
import Main.TaxiServiceMain;
import Rides.Ride;
import ServiceData.TaxiService;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RidesByPhoneDisplay extends JFrame {

    private JToolBar mainToolbar = new JToolBar();
    private JButton btnEdit = new JButton();
    private JButton btnDelete = new JButton();
    private JButton btnAccept = new JButton();
    private JTextField jtfFilter = new JTextField();

    private DefaultTableModel tableModel;
    private JTable ApplicationRidesDisplay;

    private TaxiService taxiService;

    public RidesByPhoneDisplay(TaxiService taxiService) {
        this.taxiService = taxiService;
        setTitle("Ordered By Phone");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
    }

    private void initGUI() {
        ImageIcon editIcon = new ImageIcon(getClass().getResource("/images/edit.gif"));
        btnEdit.setIcon(editIcon);
        ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/images/remove.gif"));
        btnDelete.setIcon(deleteIcon);
        ImageIcon acceptIcon = new ImageIcon(getClass().getResource("/images/accept.gif"));
        btnAccept.setIcon(acceptIcon);

        mainToolbar.add(btnDelete);
        mainToolbar.add(btnAccept);
        add(mainToolbar, BorderLayout.NORTH);

        String[] headings = new String[] {"Ride ID", "Order Date", "Start Address", "Destination Address", "Customer", "Driver", "KM Passed", "Duration", "Status", "Note", "Ordered By", "Car Age", "Pet Friendly"};
        Object[][] content = new Object[taxiService.RidesByPhoneForDriver().size()][headings.length];

        for(int i=0; i<taxiService.RidesByPhoneForDriver().size(); i++) {
            Ride ride = taxiService.RidesByPhoneForDriver().get(i);
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
            content[i][10] = ride.getRideOrderType();
            content[i][11] = ride.getCarAgeOrder();
            content[i][12] = ride.getPetFriendly();
        }

        tableModel = new DefaultTableModel(content, headings);
        ApplicationRidesDisplay = new JTable(tableModel);

        ApplicationRidesDisplay.setRowSelectionAllowed(true);
        ApplicationRidesDisplay.setColumnSelectionAllowed(false);
        ApplicationRidesDisplay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ApplicationRidesDisplay.setDefaultEditor(Object.class, null);
        ApplicationRidesDisplay.getTableHeader().setReorderingAllowed(false);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Specify a word to match:"), BorderLayout.WEST);
        panel.add(jtfFilter, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        add(new JScrollPane(ApplicationRidesDisplay), BorderLayout.CENTER);

        ApplicationRidesDisplay.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for(int i=0; i< headings.length; i++) {
            ApplicationRidesDisplay.getColumnModel().getColumn(0).setPreferredWidth(50);
            ApplicationRidesDisplay.getColumnModel().getColumn(1).setPreferredWidth(110);
            ApplicationRidesDisplay.getColumnModel().getColumn(2).setPreferredWidth(100);
            ApplicationRidesDisplay.getColumnModel().getColumn(3).setPreferredWidth(100);
            ApplicationRidesDisplay.getColumnModel().getColumn(4).setPreferredWidth(100);
            ApplicationRidesDisplay.getColumnModel().getColumn(5).setPreferredWidth(100);
            ApplicationRidesDisplay.getColumnModel().getColumn(6).setPreferredWidth(100);
            ApplicationRidesDisplay.getColumnModel().getColumn(7).setPreferredWidth(100);
            ApplicationRidesDisplay.getColumnModel().getColumn(8).setPreferredWidth(115);
            ApplicationRidesDisplay.getColumnModel().getColumn(9).setPreferredWidth(100);
            ApplicationRidesDisplay.getColumnModel().getColumn(10).setPreferredWidth(100);
            ApplicationRidesDisplay.getColumnModel().getColumn(11).setPreferredWidth(100);
            ApplicationRidesDisplay.getColumnModel().getColumn(12).setPreferredWidth(100);
        }
        JScrollPane scrollPane = new JScrollPane(ApplicationRidesDisplay);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initActions() {
        TableRowSorter<TableModel> rowSorter
                = new TableRowSorter<>(ApplicationRidesDisplay.getModel());
        ApplicationRidesDisplay.setRowSorter(rowSorter);

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = ApplicationRidesDisplay.getSelectedRow();
                if(row == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a row.", "Error", JOptionPane.WARNING_MESSAGE);
                }else {
                    int rideID = Integer.parseInt(tableModel.getValueAt(row, 0).toString());
                    Ride ride = taxiService.findRide(rideID);

                    int choice = JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to CANCEL this Ride?",
                            rideID + " - Confirm Choice", JOptionPane.YES_NO_OPTION);
                    if(choice == JOptionPane.YES_OPTION) {
                        ride.setRideStatus(RideStatus.Denied);
                        taxiService.saveRides(TaxiServiceMain.Rides_File);
                    }
                }
            }
        });

        btnAccept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = ApplicationRidesDisplay.getSelectedRow();
                if(row == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a row.", "Error", JOptionPane.WARNING_MESSAGE);
                }else {
                    int rideID = Integer.parseInt(tableModel.getValueAt(row, 0).toString());
                    Ride ride = taxiService.findRide(rideID);

                    int choice = JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to ACCEPT this Ride?",
                            rideID + " - Confirm Choice", JOptionPane.YES_NO_OPTION);
                    if(choice == JOptionPane.YES_OPTION) {
                        ride.setRideStatus(RideStatus.Accepted);
                        RidesByPhoneForm rf = new RidesByPhoneForm(taxiService, ride);
                        rf.setVisible(true);
                        taxiService.saveRides(TaxiServiceMain.Rides_File);
                    }
                }
            }
        });

        jtfFilter.getDocument().addDocumentListener(new DocumentListener(){
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = jtfFilter.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

        });

    }

}
