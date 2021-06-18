package GUI.DispatcherOptions;

import Cars.Car;
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

public class CarsDisplay extends JFrame {
    private JToolBar mainToolbar = new JToolBar();
    private JButton btnAdd = new JButton();
    private JButton btnEdit = new JButton();
    private JButton btnDelete = new JButton();
    private JTextField jtfFilter = new JTextField();

    private DefaultTableModel tableModel;
    private JTable CarsDisplay;

    private TaxiService taxiService;

    public CarsDisplay(TaxiService taxiService) {
        this.taxiService = taxiService;
        setTitle("Cars");
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

        String[] headings = new String[] {"ID Code", "ID", "Model", "Manufacturer", "Year Produced", "Registrations", "Taxi Number", "Type"};
        Object[][] content = new Object[taxiService.allNotDeletedCars().size()][headings.length];

        for(int i=0; i<taxiService.allNotDeletedCars().size(); i++) {
            Car car = taxiService.allNotDeletedCars().get(i);
            content[i][0] = car.getIDCode();
            content[i][1] = car.getCarID();
            content[i][2] = car.getModel();
            content[i][3] = car.getManufacturer();
            content[i][4] = car.getYearProduced();
            content[i][5] = car.getRegistrationNumber();
            content[i][6] = car.getTaxiNumber();
            content[i][7] = car.getVehicletype();
        }

        tableModel = new DefaultTableModel(content, headings);
        CarsDisplay = new JTable(tableModel);
        CarsDisplay.setRowSelectionAllowed(true);
        CarsDisplay.setColumnSelectionAllowed(false);
        CarsDisplay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        CarsDisplay.setDefaultEditor(Object.class, null);
        CarsDisplay.getTableHeader().setReorderingAllowed(false);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(new JLabel("Specify a word to match:"), BorderLayout.WEST);
        panel.add(jtfFilter, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        add(new JScrollPane(CarsDisplay), BorderLayout.CENTER);

        CarsDisplay.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for(int i=0; i< headings.length; i++) {
            CarsDisplay.getColumnModel().getColumn(0).setPreferredWidth(70);
            CarsDisplay.getColumnModel().getColumn(1).setPreferredWidth(40);
            CarsDisplay.getColumnModel().getColumn(2).setPreferredWidth(100);
            CarsDisplay.getColumnModel().getColumn(3).setPreferredWidth(100);
            CarsDisplay.getColumnModel().getColumn(4).setPreferredWidth(100);
            CarsDisplay.getColumnModel().getColumn(5).setPreferredWidth(100);
            CarsDisplay.getColumnModel().getColumn(6).setPreferredWidth(100);
            CarsDisplay.getColumnModel().getColumn(7).setPreferredWidth(100);
        }
        JScrollPane scrollPane = new JScrollPane(CarsDisplay);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initActions() {
        TableRowSorter<TableModel> rowSorter
                = new TableRowSorter<>(CarsDisplay.getModel());
        CarsDisplay.setRowSorter(rowSorter);

        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = CarsDisplay.getSelectedRow();
                if(row == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a row.", "Error", JOptionPane.WARNING_MESSAGE);
                }else {
                    String IDCode = tableModel.getValueAt(row, 0).toString();
                    Car car = taxiService.findCar(IDCode);

                    int choice = JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to delete this Car??",
                            IDCode + " - Confirm Choice", JOptionPane.YES_NO_OPTION);
                    if(choice == JOptionPane.YES_OPTION) {
                        car.setDeleted(true);
                        tableModel.removeRow(row);
                        taxiService.saveDrivers(TaxiServiceMain.Drivers_File);
                    }
                }
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarsForm cf = new CarsForm(taxiService, null);
                cf.setVisible(true);
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = CarsDisplay.getSelectedRow();
                if(row == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a row.", "Error", JOptionPane.WARNING_MESSAGE);
                }else {
                    String IDCode = tableModel.getValueAt(row, 0).toString();
                    Car car = taxiService.findCar(IDCode);
                    if(car == null) {
                        JOptionPane.showMessageDialog(null, "Couldn't find a Car with that ID Code", "Error", JOptionPane.WARNING_MESSAGE);
                    }else {
                        CarsForm cf = new CarsForm(taxiService, car);
                        cf.setVisible(true);
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
