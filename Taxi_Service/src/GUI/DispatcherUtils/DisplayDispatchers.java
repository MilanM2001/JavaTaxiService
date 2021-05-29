package GUI.DispatcherUtils;

import AllUsers.Dispatcher;
import AllUsers.Driver;
import Main.TaxiService;
import Main.TaxiServiceMain;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayDispatchers extends JFrame {

    private JToolBar mainToolbar = new JToolBar();
    private JButton btnAdd = new JButton();
    private JButton btnEdit = new JButton();
    private JButton btnDelete = new JButton();

    private DefaultTableModel tableModel;
    private JTable DispatchersDisplay;

    private TaxiService taxiService;

    public DisplayDispatchers(TaxiService taxiService) {
        this.taxiService = taxiService;
        setTitle("Dispatchers");
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

        String[] headings = new String[] {"Username", "Password", "Name", "Last Name", "JMBG", "Address", "Phone Number", "Gender", "ID", "Role", "Pay", "Phone Line", "Department"};
        Object[][] content = new Object[taxiService.allNotDeletedDispatchers().size()][headings.length];

        for(int i=0; i<taxiService.allNotDeletedDispatchers().size(); i++) {
            Dispatcher dispatcher = taxiService.allNotDeletedDispatchers().get(i);
            content[i][0] = dispatcher.getUsername();
            content[i][1] = dispatcher.getPassword();
            content[i][2] = dispatcher.getName();
            content[i][3] = dispatcher.getLastName();
            content[i][4] = dispatcher.getJmbg();
            content[i][5] = dispatcher.getAddress();
            content[i][6] = dispatcher.getPhoneNumber();
            content[i][7] = dispatcher.getGender();
            content[i][8] = dispatcher.getId();
            content[i][9] = dispatcher.getRoles();
            content[i][10] = dispatcher.getDispatcherPay();
            content[i][11] = dispatcher.getPhoneLine();
            content[i][12] = dispatcher.getGender();
        }

        tableModel = new DefaultTableModel(content, headings);
        DispatchersDisplay = new JTable(tableModel);

        DispatchersDisplay.setRowSelectionAllowed(true);
        DispatchersDisplay.setColumnSelectionAllowed(false);
        DispatchersDisplay.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DispatchersDisplay.setDefaultEditor(Object.class, null);
        DispatchersDisplay.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(DispatchersDisplay);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void initActions() {
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = DispatchersDisplay.getSelectedRow();
                if(row == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a row.", "Error", JOptionPane.WARNING_MESSAGE);
                }else {
                    String username = tableModel.getValueAt(row, 3).toString();
                    Dispatcher dispatcher = taxiService.findDispatcher(username);

                    int choice = JOptionPane.showConfirmDialog(null,
                            "Are you sure you want to delete the user?",
                            username + " - Confirm Choice", JOptionPane.YES_NO_OPTION);
                    if(choice == JOptionPane.YES_OPTION) {
                        dispatcher.setDeleted(true);
                        tableModel.removeRow(row);
                        taxiService.saveDispatchers(TaxiServiceMain.Dispatchers_File);
                    }
                }
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DispatchersForm df = new DispatchersForm(taxiService, null);
                df.setVisible(true);
            }
        });

        btnEdit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int row = DispatchersDisplay.getSelectedRow();
                if(row == -1) {
                    JOptionPane.showMessageDialog(null, "Please select a row.", "Error", JOptionPane.WARNING_MESSAGE);
                }else {
                    String username = tableModel.getValueAt(row, 3).toString();
                    Dispatcher dispatcher = taxiService.findDispatcher(username);
                    if(dispatcher == null) {
                        JOptionPane.showMessageDialog(null, "Couldn't find a Dispatcher with that Username", "Error", JOptionPane.WARNING_MESSAGE);
                    }else {
                        DispatchersForm df = new DispatchersForm(taxiService, dispatcher);
                        df.setVisible(true);
                    }
                }
            }
        });
    }



}
