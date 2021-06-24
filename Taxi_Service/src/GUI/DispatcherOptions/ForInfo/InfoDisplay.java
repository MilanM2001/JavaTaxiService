package GUI.DispatcherOptions.ForInfo;

import ServiceData.TaxiService;
import ServiceData.TaxiServiceInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoDisplay extends JFrame {

    private JToolBar mainToolbar = new JToolBar();
    private JButton btnEdit = new JButton();

    private DefaultTableModel tableModel;
    private JTable InfoDisplay;

    private TaxiService taxiService;

    public InfoDisplay(TaxiService taxiService) {
        this.taxiService = taxiService;
        setTitle("Info");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
    }

    private void initGUI() {
        ImageIcon editIcon = new ImageIcon(getClass().getResource("/images/edit.gif"));
        btnEdit.setIcon(editIcon);

        mainToolbar.add(btnEdit);
        add(mainToolbar, BorderLayout.NORTH);

        String[] headings = new String[] {"PIB", "Service Name", "Service Address", "Starting Price", "Price Per KM"};
        Object[][] content = new Object[taxiService.allNotDeletedInfo().size()][headings.length];

        for(int i=0; i<taxiService.allNotDeletedInfo().size(); i++) {
            TaxiServiceInfo taxiServiceInfo = taxiService.allNotDeletedInfo().get(i);
            content[i][0] = taxiServiceInfo.getPIB();
            content[i][1] = taxiServiceInfo.getTaxiServiceName();
            content[i][2] = taxiServiceInfo.getTaxiServiceAddress();
            content[i][3] = taxiServiceInfo.getTaxiServiceStartingPrice();
            content[i][4] = taxiServiceInfo.getTaxiServicePricePerKM();
        }

        tableModel = new DefaultTableModel(content, headings);
        InfoDisplay = new JTable(tableModel);

        InfoDisplay.setRowSelectionAllowed(true);
        InfoDisplay.setColumnSelectionAllowed(false);
        InfoDisplay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        InfoDisplay.setDefaultEditor(Object.class, null);
        InfoDisplay.getTableHeader().setReorderingAllowed(false);

        InfoDisplay.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for(int i=0; i< headings.length; i++) {
            InfoDisplay.getColumnModel().getColumn(0).setPreferredWidth(50);
            InfoDisplay.getColumnModel().getColumn(1).setPreferredWidth(100);
            InfoDisplay.getColumnModel().getColumn(2).setPreferredWidth(100);
            InfoDisplay.getColumnModel().getColumn(3).setPreferredWidth(100);
            InfoDisplay.getColumnModel().getColumn(4).setPreferredWidth(100);

        }
        JScrollPane scrollPane = new JScrollPane(InfoDisplay);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initActions() {
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = InfoDisplay.getSelectedRow();
                if(row == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a row.", "Error", JOptionPane.WARNING_MESSAGE);
                }else {
                    String TaxiServiceName = tableModel.getValueAt(row, 1).toString();
                    TaxiServiceInfo taxiServiceInfo = taxiService.findInfo(TaxiServiceName);
                    if(taxiServiceInfo == null) {
                        JOptionPane.showMessageDialog(null, "Couldn't find a Taxi Service with that Name", "Error", JOptionPane.WARNING_MESSAGE);
                    }else {
                        InfoForm If = new InfoForm(taxiService, taxiServiceInfo);
                        If.setVisible(true);
                    }
                }
            }
        });
    }


}
