package GUI;

import Utils.WindowUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UsersFrame extends JFrame {
    private JToolBar tbKorisnici;
    private JTable tKorisnici;
    private UsersTableModel tmKorisnici;
    private JScrollPane sKorisnici;
    private JButton bDodaj, bIzmeni, bObrisi;

    public UsersFrame() {
        setTitle("Taxi Service");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        WindowUtils.centerOnScreen(this);
        initGui();
    }

    private void initGui() {
        tbKorisnici = new JToolBar();
        add(tbKorisnici, BorderLayout.NORTH);
        tmKorisnici = new UsersTableModel();
        tKorisnici = new JTable(tmKorisnici);
        sKorisnici = new JScrollPane(tKorisnici);
        add(sKorisnici, BorderLayout.CENTER);
        bDodaj = new JButton("Dodaj");
        tbKorisnici.add(bDodaj);
        bIzmeni = new JButton("Izmeni");
        bObrisi = new JButton("Obrisi");
        tbKorisnici.add(bIzmeni);
        tbKorisnici.add(bObrisi);

        bDodaj.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                UsersForm uf = new UsersForm(tmKorisnici, null, -1);
                uf.setVisible(true);
            }
        });

        bIzmeni.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                int row = tKorisnici.getSelectedRow();
                if(row!=-1) {
                    KorisnikDAO dao = new KorisnikDAO();
                    Korisnik k = dao.loadKorisnikByKorisnickoIme((String)tKorisnici.getValueAt(row, 0));
                    KorisnikForma kf = new KorisnikForma(tmKorisnici, k, row);
                    kf.setVisible(true);
                }
            }
        });

        bObrisi.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                int row = tKorisnici.getSelectedRow();
                if(row!=-1) {
                    tmKorisnici.delete(row);
                }
            }
        });
    }

}
