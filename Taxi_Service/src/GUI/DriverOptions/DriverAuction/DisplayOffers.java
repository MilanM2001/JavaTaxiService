package GUI.DriverOptions.DriverAuction;

import AllUsers.Driver;
import Enums.RideStatus;
import GUI.DriverOptions.OrderedRides.RidesByPhoneForm;
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

public class DisplayOffers extends JFrame {

    private JToolBar mainToolbar = new JToolBar();
    private JTextField jtfFilter = new JTextField();
    private DefaultTableModel tableModel;
    private JButton btnAccept = new JButton();
    private JTable OffersDisplay;

    private TaxiService taxiService;

    public DisplayOffers(TaxiService taxiService) {
        this.taxiService = taxiService;
        setTitle("Auction a Ride");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
    }

    private void initGUI() {
        ImageIcon acceptIcon = new ImageIcon(getClass().getResource("/images/accept.gif"));
        btnAccept.setIcon(acceptIcon);
        String[] headings = new String[]{"Ride ID", "Order Date", "Start Address", "Destination Address", "Customer", "Driver", "KM Passed", "Duration", "Status", "Note", "Ordered By", "Car Age", "Pet Friendly"};
        Object[][] content = new Object[taxiService.allNotAuctionedRides().size()][headings.length];
        mainToolbar.add(btnAccept);
        add(mainToolbar, BorderLayout.NORTH);

        for (int i = 0; i < taxiService.allNotAuctionedRides().size(); i++) {
            Ride ride = taxiService.allNotAuctionedRides().get(i);
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
        OffersDisplay = new JTable(tableModel);

        OffersDisplay.setRowSelectionAllowed(true);
        OffersDisplay.setColumnSelectionAllowed(false);
        OffersDisplay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        OffersDisplay.setDefaultEditor(Object.class, null);
        OffersDisplay.getTableHeader().setReorderingAllowed(false);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Specify a word to match:"), BorderLayout.WEST);
        panel.add(jtfFilter, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        add(new JScrollPane(OffersDisplay), BorderLayout.CENTER);

        OffersDisplay.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for (int i = 0; i < headings.length; i++) {
            OffersDisplay.getColumnModel().getColumn(0).setPreferredWidth(50);
            OffersDisplay.getColumnModel().getColumn(1).setPreferredWidth(110);
            OffersDisplay.getColumnModel().getColumn(2).setPreferredWidth(100);
            OffersDisplay.getColumnModel().getColumn(3).setPreferredWidth(100);
            OffersDisplay.getColumnModel().getColumn(4).setPreferredWidth(100);
            OffersDisplay.getColumnModel().getColumn(5).setPreferredWidth(100);
            OffersDisplay.getColumnModel().getColumn(6).setPreferredWidth(100);
            OffersDisplay.getColumnModel().getColumn(7).setPreferredWidth(100);
            OffersDisplay.getColumnModel().getColumn(8).setPreferredWidth(115);
            OffersDisplay.getColumnModel().getColumn(9).setPreferredWidth(100);
            OffersDisplay.getColumnModel().getColumn(10).setPreferredWidth(100);
            OffersDisplay.getColumnModel().getColumn(11).setPreferredWidth(100);
            OffersDisplay.getColumnModel().getColumn(12).setPreferredWidth(100);
        }
        JScrollPane scrollPane = new JScrollPane(OffersDisplay);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initActions() {
        TableRowSorter<TableModel> rowSorter
                = new TableRowSorter<>(OffersDisplay.getModel());
        OffersDisplay.setRowSorter(rowSorter);

        btnAccept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = OffersDisplay.getSelectedRow();
                if (row == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a row.", "Error", JOptionPane.WARNING_MESSAGE);
                } else {
                    int rideID = Integer.parseInt(tableModel.getValueAt(row, 0).toString());
                    Ride ride = taxiService.findRide(rideID);
                    int driverID = Integer.parseInt(tableModel.getValueAt(row, 0).toString());
                    Driver driver = taxiService.findDriverID(driverID);
                    int choice = JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to Auction this Ride?",
                            rideID + " - Confirm Choice", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        ride.setRideStatus(RideStatus.Auctioned);
                        DriverAuctionForm auf = new DriverAuctionForm(taxiService, ride, driver);
                        auf.setVisible(true);
                        taxiService.saveOffers(TaxiServiceMain.Offers_File);
                    }
                }
            }
        });

        jtfFilter.getDocument().addDocumentListener(new DocumentListener() {
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
