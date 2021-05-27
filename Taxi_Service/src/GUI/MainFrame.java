package GUI;

import AllUsers.Users;
import Utils.WindowUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private JMenuBar meni;
    private JMenu korisniciMeni;
    private JMenuItem korisniciItem;

    public MainFrame() {
        setTitle("Taxi Service");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        WindowUtils.centerOnScreen(this);
        initGui();
    }

    private void initGui() {
        meni = new JMenuBar();
        setJMenuBar(meni);
        korisniciMeni = new JMenu("Korisnici");
        meni.add(korisniciMeni);
        korisniciItem = new JMenuItem("Korisnici");
        korisniciMeni.add(korisniciItem);

        korisniciItem.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                UsersFrame uf = new UsersFrame();
                uf.setVisible(true);
            }
        });
    }
}
