package GUI.DispatcherOptions.ReportStatistics;

import AllUsers.Driver;
import Cars.Car;
import Enums.Gender;
import Enums.Roles;
import GUI.DispatcherOptions.ForDrivers.DriversForm;
import Main.TaxiServiceMain;
import Rides.Ride;
import ServiceData.TaxiService;
import ServiceData.TaxiServiceInfo;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatisticsForm extends JFrame {

    private JTextField txtRidesInTotal = new JTextField(20);

    private JTextField txtPhoneRidesInTotal = new JTextField(20);

    private JTextField txtAppRidesInTotal = new JTextField(20);

    private JTextField txtActiveDrivers = new JTextField(20);

    private JTextField txtAverageRideDuration = new JTextField(20);

    private JTextField txtAverageKMPassed = new JTextField(20);

    private JTextField txtPayForAllRides = new JTextField(20);

    private JTextField txtAveragePayPerRide = new JTextField(20);

    private JButton btnOk = new JButton("OK");
    private JButton btnCancel = new JButton("Cancel");

    private TaxiService taxiService;
    private Statistics statistics;
    private TaxiServiceInfo taxiServiceInfo;

    public StatisticsForm(TaxiService taxiService, TaxiServiceInfo taxiServiceInfo, Statistics statistics) {
        this.taxiService = taxiService;
        this.statistics = statistics;
        this.taxiServiceInfo = taxiServiceInfo;
        if(statistics == null) {
            setTitle("Updating Statistics");
        }
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
        setResizable(false);
        pack();
        saveStatisticsToFile();
    }

    public void saveStatisticsToFile() {
        int ridesInTotal = taxiService.RidesInTotal();
        int phoneRidesInTotal = taxiService.RidesByPhoneNumber();
        int appRidesInTotal = taxiService.RidesByAppNumber();
        int activeDrivers = taxiService.ActiveDrivers();
        double averageRideDuration = taxiService.AverageRideDuration();
        double averageKMPassed = taxiService.AverageKMPassed();
        double payForAllRides = taxiService.payForAllRides(taxiServiceInfo.getTaxiServiceStartingPrice(), taxiServiceInfo.getTaxiServicePricePerKM());
        double averagePayPerRide = payForAllRides/ridesInTotal;


        Statistics newStatistics = new Statistics(ridesInTotal, phoneRidesInTotal, appRidesInTotal, activeDrivers, averageRideDuration, averageKMPassed, payForAllRides, averagePayPerRide, false);
        taxiService.addStatistics(newStatistics);

        taxiService.saveStatistics(TaxiServiceMain.Statistics_File);
    }

    private void initGUI() {
        MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
        setLayout(layout);

        if (statistics != null) {
            //FillFields();
        }

        add(new JLabel());
        add(btnOk, "split 2");
        add(btnCancel);
    }

    private void initActions() {
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Validation()) {
                    int ridesInTotal = taxiService.RidesInTotal();
                    int phoneRidesInTotal = taxiService.RidesByPhoneNumber();
                    int appRidesInTotal = taxiService.RidesByAppNumber();
                    int activeDrivers = taxiService.ActiveDrivers();
                    double averageRideDuration = taxiService.AverageRideDuration();
                    double averageKMPassed = taxiService.AverageKMPassed();
                    double payForAllRides = taxiService.payForAllRides(taxiServiceInfo.getTaxiServiceStartingPrice(), taxiServiceInfo.getTaxiServicePricePerKM());
                    double averagePayPerRide = payForAllRides/ridesInTotal;


                    if(statistics == null) {
                        Statistics newStatistics = new Statistics(ridesInTotal, phoneRidesInTotal, appRidesInTotal, activeDrivers, averageRideDuration, averageKMPassed, payForAllRides, averagePayPerRide, false);
                        taxiService.addStatistics(newStatistics);
                    }
                    taxiService.saveStatistics(TaxiServiceMain.Statistics_File);
                    StatisticsForm.this.dispose();
                    StatisticsForm.this.setVisible(false);
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StatisticsForm.this.dispose();
                StatisticsForm.this.setVisible(false);
            }
        });
    }

    private boolean Validation() {
        boolean ok = true;
        String message = "Please correct the following mistakes:\n";
        return ok;
    }
}
