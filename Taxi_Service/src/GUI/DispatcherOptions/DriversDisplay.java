package GUI.DispatcherOptions;

import AllUsers.Driver;
import ServiceData.TaxiService;
import Main.TaxiServiceMain;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DriversDisplay extends JFrame {

    private JToolBar mainToolbar = new JToolBar();
    private JButton btnAdd = new JButton();
    private JButton btnEdit = new JButton();
    private JButton btnDelete = new JButton();
    private JTextField jtfFilter = new JTextField();

    private DefaultTableModel tableModel;
    private JTable DriversDisplay;

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

        String[] headings = new String[] {"Username", "Password", "Name", "Last Name", "JMBG", "Address", "Phone Number", "Gender", "ID", "Role", "Pay", "Card"};
        Object[][] content = new Object[taxiService.allNotDeletedDrivers().size()][headings.length];

        for(int i=0; i<taxiService.allNotDeletedDrivers().size(); i++) {
            Driver driver = taxiService.allNotDeletedDrivers().get(i);
            content[i][0] = driver.getUsername();
            content[i][1] = driver.getPassword();
            content[i][2] = driver.getName();
            content[i][3] = driver.getLastName();
            content[i][4] = driver.getJmbg();
            content[i][5] = driver.getAddress();
            content[i][6] = driver.getPhoneNumber();
            content[i][7] = driver.getGender();
            content[i][8] = driver.getId();
            content[i][9] = driver.getRoles();
            content[i][10] = driver.getDriverPay();
            content[i][11] = driver.getMembershipCard();

        }

        tableModel = new DefaultTableModel(content, headings);
        DriversDisplay = new JTable(tableModel);
        DriversDisplay.setRowSelectionAllowed(true);
        DriversDisplay.setColumnSelectionAllowed(false);
        DriversDisplay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DriversDisplay.setDefaultEditor(Object.class, null);
        DriversDisplay.getTableHeader().setReorderingAllowed(false);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Specify a word to match:"), BorderLayout.WEST);
        panel.add(jtfFilter, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        add(new JScrollPane(DriversDisplay), BorderLayout.CENTER);


        DriversDisplay.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for(int i=0; i< headings.length; i++) {
            DriversDisplay.getColumnModel().getColumn(0).setPreferredWidth(100);
            DriversDisplay.getColumnModel().getColumn(1).setPreferredWidth(100);
            DriversDisplay.getColumnModel().getColumn(2).setPreferredWidth(100);
            DriversDisplay.getColumnModel().getColumn(3).setPreferredWidth(100);
            DriversDisplay.getColumnModel().getColumn(4).setPreferredWidth(100);
            DriversDisplay.getColumnModel().getColumn(5).setPreferredWidth(100);
            DriversDisplay.getColumnModel().getColumn(6).setPreferredWidth(100);
            DriversDisplay.getColumnModel().getColumn(7).setPreferredWidth(100);
            DriversDisplay.getColumnModel().getColumn(8).setPreferredWidth(40);
            DriversDisplay.getColumnModel().getColumn(9).setPreferredWidth(100);
            DriversDisplay.getColumnModel().getColumn(10).setPreferredWidth(100);
            DriversDisplay.getColumnModel().getColumn(11).setPreferredWidth(100);
        }
        JScrollPane scrollPane = new JScrollPane(DriversDisplay);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initActions() {
        TableRowSorter<TableModel> rowSorter
                = new TableRowSorter<>(DriversDisplay.getModel());
        DriversDisplay.setRowSorter(rowSorter);

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = DriversDisplay.getSelectedRow();
                if(row == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a row.", "Error", JOptionPane.WARNING_MESSAGE);
                }else {
                    String username = tableModel.getValueAt(row, 0).toString();
                    Driver driver = taxiService.findDriver(username);

                    int choice = JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to delete the Driver?",
                            username + " - Confirm Choice", JOptionPane.YES_NO_OPTION);
                    if(choice == JOptionPane.YES_OPTION) {
                        driver.setDeleted(true);
                        tableModel.removeRow(row);
                        taxiService.saveDrivers(TaxiServiceMain.Drivers_File);
                    }
                }
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DriversForm df = new DriversForm(taxiService, null);
                df.setVisible(true);
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = DriversDisplay.getSelectedRow();
                if(row == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a row.", "Error", JOptionPane.WARNING_MESSAGE);
                }else {
                    String username = tableModel.getValueAt(row, 0).toString();
                    Driver driver = taxiService.findDriver(username);
                    if(driver == null) {
                        JOptionPane.showMessageDialog(null, "Couldn't find a Driver with that Username", "Error", JOptionPane.WARNING_MESSAGE);
                    }else {
                        DriversForm df = new DriversForm(taxiService, driver);
                        df.setVisible(true);
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
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
    }

}
