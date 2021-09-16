package GUI.DispatcherOptions.DispatcherAuction;

import Rides.Offer;
import Rides.Ride;
import ServiceData.TaxiService;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class ShowOffersDisplay extends JFrame {

    private JTextField jtfFilter = new JTextField();
    private DefaultTableModel tableModel;
    private JTable OffersDisplay;

    private TaxiService taxiService;

    public ShowOffersDisplay(TaxiService taxiService) {
        this.taxiService = taxiService;
        setTitle("Rides");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
    }

    private void initGUI() {
        String[] headings = new String[] {"Offer ID", "Minutes Needed", "Date Created", "Ride ID", "Driver ID"};
        Object[][] content = new Object[taxiService.allNotDeletedOffers().size()][headings.length];

        for(int i=0; i<taxiService.allNotDeletedOffers().size(); i++) {
            Offer offer = taxiService.allNotDeletedOffers().get(i);
            content[i][0] = offer.getOrderId();
            content[i][1] = offer.getMinutes();
            content[i][2] = offer.getDateOfCreation();
            content[i][3] = offer.getRideID();
            content[i][4] = offer.getDriverID();
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
        for(int i=0; i< headings.length; i++) {
            OffersDisplay.getColumnModel().getColumn(0).setPreferredWidth(50);
            OffersDisplay.getColumnModel().getColumn(1).setPreferredWidth(110);
            OffersDisplay.getColumnModel().getColumn(2).setPreferredWidth(100);
            OffersDisplay.getColumnModel().getColumn(3).setPreferredWidth(100);
            OffersDisplay.getColumnModel().getColumn(4).setPreferredWidth(100);
        }
        JScrollPane scrollPane = new JScrollPane(OffersDisplay);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initActions() {
        TableRowSorter<TableModel> rowSorter
                = new TableRowSorter<>(OffersDisplay.getModel());
        OffersDisplay.setRowSorter(rowSorter);

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
