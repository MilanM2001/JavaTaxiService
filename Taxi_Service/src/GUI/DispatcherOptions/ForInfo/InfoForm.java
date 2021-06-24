package GUI.DispatcherOptions.ForInfo;

import Main.TaxiServiceMain;
import ServiceData.TaxiService;
import ServiceData.TaxiServiceInfo;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoForm extends JFrame {

    private JLabel lblServicePIB = new JLabel("PIB");
    private JTextField txtServicePIB = new JTextField(20);

    private JLabel lblServiceName = new JLabel("Service Name");
    private JTextField txtServiceName = new JTextField(20);

    private JLabel lblServiceAddress = new JLabel("Service Address");
    private JTextField txtServiceAddress = new JTextField(20);

    private JLabel lblServiceStartingPrice = new JLabel("Starting Price");
    private JTextField txtServiceStartingPrice = new JTextField(20);

    private JLabel lblServicePricePerKM = new JLabel("Service Price Per KM");
    private JTextField txtServicePricePerKM = new JTextField(20);

    private JButton btnOk = new JButton("OK");
    private JButton btnCancel = new JButton("Cancel");

    private TaxiService taxiService;
    private TaxiServiceInfo taxiServiceInfo;

    public InfoForm(TaxiService taxiService, TaxiServiceInfo taxiServiceInfo) {
        this.taxiService = taxiService;
        this.taxiServiceInfo = taxiServiceInfo;
        if(taxiService == null) {

        }else {
            setTitle("Change Service Info");
        }
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        initGUI();
        initActions();
        setResizable(false);
        pack();
    }

    private void initGUI() {
        MigLayout layout = new MigLayout("wrap 2", "[][]", "[][][][][]20[]");
        setLayout(layout);

        if(taxiServiceInfo != null) {
            FillFields();
        }
        add(lblServicePIB);
        add(txtServicePIB);

        add(lblServiceName);
        add(txtServiceName);

        add(lblServiceAddress);
        add(txtServiceAddress);

        add(lblServiceStartingPrice);
        add(txtServiceStartingPrice);

        add(lblServicePricePerKM);
        add(txtServicePricePerKM);

        add(new JLabel());
        add(btnOk, "split 2");
        add(btnCancel);
    }

    private void initActions() {
        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(InfoValidation()) {
                    int PIB = Integer.parseInt(txtServicePIB.getText().trim());
                    String TaxiServiceName = txtServiceName.getText().trim();
                    String TaxiServiceAddress = txtServiceAddress.getText().trim();
                    double TaxiServiceStartingPrice = Double.parseDouble(txtServiceStartingPrice.getText().trim());
                    double TaxiServicePricePerKM = Double.parseDouble(txtServicePricePerKM.getText().trim());

                    if(taxiServiceInfo == null) {
                        TaxiServiceInfo newTaxiServiceInfo = new TaxiServiceInfo(PIB, TaxiServiceName, TaxiServiceAddress, TaxiServiceStartingPrice, TaxiServicePricePerKM, false);
                        taxiService.addInfo(newTaxiServiceInfo);
                    }else {
                        taxiServiceInfo.setPIB(PIB);
                        taxiServiceInfo.setTaxiServiceName(TaxiServiceName);
                        taxiServiceInfo.setTaxiServiceAddress(TaxiServiceAddress);
                        taxiServiceInfo.setTaxiServiceStartingPrice(TaxiServiceStartingPrice);
                        taxiServiceInfo.setTaxiServicePricePerKM(TaxiServicePricePerKM);

                    }
                    taxiService.saveInfo(TaxiServiceMain.Info_File);
                    InfoForm.this.dispose();
                    InfoForm.this.setVisible(false);
                }
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InfoForm.this.dispose();
                InfoForm.this.setVisible(false);
            }
        });
    }

    private void FillFields() {
        txtServicePIB.setText(String.valueOf(taxiServiceInfo.getPIB()));
        txtServiceName.setText(taxiServiceInfo.getTaxiServiceName());
        txtServiceAddress.setText(taxiServiceInfo.getTaxiServiceAddress());
        txtServiceStartingPrice.setText(String.valueOf(taxiServiceInfo.getTaxiServiceStartingPrice()));
        txtServicePricePerKM.setText(String.valueOf(taxiServiceInfo.getTaxiServicePricePerKM()));
    }

    private boolean InfoValidation() {
        boolean ok = true;
        String message = "Please correct the following mistakes:\n";

        if(txtServicePIB.getText().trim().equals("")) {
            message += "- PIB\n";
            ok = false;
        }
        if(txtServiceName.getText().trim().equals("")) {
            message += "- Service Name\n";
            ok = false;
        }if(txtServiceAddress.getText().trim().equals("")) {
            message += "- Service Address\n";
            ok = false;
        }if(txtServiceStartingPrice.getText().trim().equals("")) {
            message += "- Starting Price\n";
            ok = false;
        }if(txtServicePricePerKM.getText().trim().equals("")) {
            message += "- Price Per KM\n";
            ok = false;
        }else if(taxiServiceInfo == null){
            String TaxiServiceName = txtServiceName.getText().trim();
            TaxiServiceInfo found = taxiService.findInfo(TaxiServiceName);
            if(found != null) {
                message += "- Info with that Name already exists\n";
                ok = false;
            }
        }
        if(ok == false) {
            JOptionPane.showMessageDialog(null, message, "Incorrect Info", JOptionPane.WARNING_MESSAGE);
        }

        return ok;
    }


}
