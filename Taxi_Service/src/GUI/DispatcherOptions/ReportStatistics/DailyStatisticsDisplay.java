package GUI.DispatcherOptions.ReportStatistics;

import Main.TaxiServiceMain;
import ServiceData.TaxiService;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class DailyStatisticsDisplay extends JFrame {
    private JTextField jtfFilter = new JTextField();

    private DefaultTableModel tableModel;
    private JTable StatisticsDisplay;

    private Statistics statistics;
    private TaxiService taxiService;

    public DailyStatisticsDisplay(TaxiService taxiService) {
        this.taxiService = taxiService;
        setTitle("Daily Report");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        saveStatisticsToFile();
        initGUI();
        initActions();
    }

    public void saveStatisticsToFile() {
        int ridesInTotal = taxiService.RidesInTotal();
        int phoneRidesInTotal = taxiService.RidesByPhoneNumber();
        int appRidesInTotal = taxiService.RidesByAppNumber();
        int activeDrivers = taxiService.ActiveDrivers();
        double averageRideDuration = taxiService.AverageRideDuration();
        double averageKMPassed = taxiService.AverageKMPassed();
        double payForAllRides = taxiService.payForAllRides(taxiService.getServiceInfos().get(0).getTaxiServiceStartingPrice(), taxiService.getServiceInfos().get(0).getTaxiServicePricePerKM());
        double averagePayPerRide = payForAllRides/ridesInTotal;

        statistics = new Statistics(ridesInTotal, phoneRidesInTotal, appRidesInTotal, activeDrivers, averageRideDuration, averageKMPassed, payForAllRides, averagePayPerRide, false);
        taxiService.addStatisticsDaily(statistics);

        taxiService.saveStatistics(TaxiServiceMain.DailyStatistics_File);
    }


    private void initGUI() {
        String[] headings = new String[] {"Total Rides", "Phone Rides", "App Rides", "Active Drivers", "Average Ride Duration", "Average KM Passed", "Total Pay", "Average Pay per Ride"};
        Object[][] content = new Object[1][headings.length];

        content[0][0] = statistics.getRidesInTotal();
        content[0][1] = statistics.getPhoneRidesInTotal();
        content[0][2] = statistics.getAppRidesInTotal();
        content[0][3] = statistics.getActiveDrivers();
        content[0][4] = statistics.getAverageRideDuration();
        content[0][5] = statistics.getAverageKMPassed();
        content[0][6] = statistics.getPayForAllRides();
        content[0][7] = statistics.getAveragePayPerRide();

        tableModel = new DefaultTableModel(content, headings);
        StatisticsDisplay = new JTable(tableModel);

        StatisticsDisplay.setRowSelectionAllowed(true);
        StatisticsDisplay.setColumnSelectionAllowed(false);
        StatisticsDisplay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        StatisticsDisplay.setDefaultEditor(Object.class, null);
        StatisticsDisplay.getTableHeader().setReorderingAllowed(false);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Specify a word to match:"), BorderLayout.WEST);
        panel.add(jtfFilter, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        add(new JScrollPane(StatisticsDisplay), BorderLayout.CENTER);

        StatisticsDisplay.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for(int i=0; i< headings.length; i++) {
            StatisticsDisplay.getColumnModel().getColumn(0).setPreferredWidth(100);
            StatisticsDisplay.getColumnModel().getColumn(1).setPreferredWidth(100);
            StatisticsDisplay.getColumnModel().getColumn(2).setPreferredWidth(80);
            StatisticsDisplay.getColumnModel().getColumn(3).setPreferredWidth(90);
            StatisticsDisplay.getColumnModel().getColumn(4).setPreferredWidth(130);
            StatisticsDisplay.getColumnModel().getColumn(5).setPreferredWidth(130);
            StatisticsDisplay.getColumnModel().getColumn(6).setPreferredWidth(80);
            StatisticsDisplay.getColumnModel().getColumn(7).setPreferredWidth(130);
        }
        JScrollPane scrollPane = new JScrollPane(StatisticsDisplay);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initActions() {
        TableRowSorter<TableModel> rowSorter
                = new TableRowSorter<>(StatisticsDisplay.getModel());
        StatisticsDisplay.setRowSorter(rowSorter);

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
