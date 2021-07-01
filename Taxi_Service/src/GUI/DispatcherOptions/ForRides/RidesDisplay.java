package GUI.DispatcherOptions.ForRides;

import ServiceData.TaxiService;
import Main.TaxiServiceMain;
import Rides.Ride;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RidesDisplay extends JFrame {

    private JTextField jtfFilter = new JTextField();
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
        String[] headings = new String[] {"Ride ID", "Order Date", "Start Address", "Destination Address", "Customer", "Driver", "KM Passed", "Duration", "Status", "Note", "Ordered By"};
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
            content[i][10] = ride.getRideOrderType();
        }

        tableModel = new DefaultTableModel(content, headings);
        RidesDisplay = new JTable(tableModel);

        RidesDisplay.setRowSelectionAllowed(true);
        RidesDisplay.setColumnSelectionAllowed(false);
        RidesDisplay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        RidesDisplay.setDefaultEditor(Object.class, null);
        RidesDisplay.getTableHeader().setReorderingAllowed(false);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Specify a word to match:"), BorderLayout.WEST);
        panel.add(jtfFilter, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        add(new JScrollPane(RidesDisplay), BorderLayout.CENTER);

        RidesDisplay.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for(int i=0; i< headings.length; i++) {
            RidesDisplay.getColumnModel().getColumn(0).setPreferredWidth(50);
            RidesDisplay.getColumnModel().getColumn(1).setPreferredWidth(110);
            RidesDisplay.getColumnModel().getColumn(2).setPreferredWidth(100);
            RidesDisplay.getColumnModel().getColumn(3).setPreferredWidth(100);
            RidesDisplay.getColumnModel().getColumn(4).setPreferredWidth(100);
            RidesDisplay.getColumnModel().getColumn(5).setPreferredWidth(100);
            RidesDisplay.getColumnModel().getColumn(6).setPreferredWidth(100);
            RidesDisplay.getColumnModel().getColumn(7).setPreferredWidth(100);
            RidesDisplay.getColumnModel().getColumn(8).setPreferredWidth(115);
            RidesDisplay.getColumnModel().getColumn(9).setPreferredWidth(100);
            RidesDisplay.getColumnModel().getColumn(10).setPreferredWidth(100);
        }
        JScrollPane scrollPane = new JScrollPane(RidesDisplay);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initActions() {
        TableRowSorter<TableModel> rowSorter
                = new TableRowSorter<>(RidesDisplay.getModel());
        RidesDisplay.setRowSorter(rowSorter);

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
