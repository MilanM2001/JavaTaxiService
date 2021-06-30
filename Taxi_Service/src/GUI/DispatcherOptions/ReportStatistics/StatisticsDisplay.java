package GUI.DispatcherOptions.ReportStatistics;

import ServiceData.TaxiService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class StatisticsDisplay extends JFrame {

    private JTextField jtfFilter = new JTextField();

    private DefaultTableModel tableModel;
    private JTable StatisticsDisplay;

    private TaxiService taxiService;

    public StatisticsDisplay(TaxiService taxiService) {
        this.taxiService = taxiService;
        setTitle("Yearly Report");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
//        initGUI();
//        initActions();
    }

    private void initGui() {
        String[] headings = new String[] {"Username", "Password", "Name", "Last Name", "JMBG", "Address", "Phone Number", "Gender", "ID", "Role", "Pay", "Phone Line", "Department"};

    }

}
