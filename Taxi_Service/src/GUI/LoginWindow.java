package GUI;

import AllUsers.AllUsersDAO.UsersDAO;
import AllUsers.Customer;
import AllUsers.Dispatcher;
import AllUsers.Driver;
import AllUsers.Users;
import Main.TaxiService;
import Utils.WindowUtils;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {

    private JLabel lGreeting;
    private JLabel lUsername;
    private JTextField tUsername;
    private JLabel lPassword;
    private JPasswordField tPass;
    private JLabel lUserType;
    private JComboBox<String> cUserType;
    private JButton bOK;
    private JButton bCancel;
    private JFrame thisFrame;

    public LoginWindow() {
        setTitle("Taxi Service");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new MigLayout("wrap 2"));
        WindowUtils.centerOnScreen(this);
        initGui();
        pack();
    }

    private void initGui() {
        lGreeting = new JLabel("Ulogujte se:");
        add(lGreeting, "span 2, align center");
        lUsername = new JLabel("Kor ime:");
        add(lUsername, "align right");
        tUsername = new JTextField(15);
        add(tUsername);
        lPassword = new JLabel("Lozinka:");
        add(lPassword, "align right");
        tPass = new JPasswordField(15);
        add(tPass);
        cUserType = new JComboBox<>();
        cUserType.addItem("Admin");
        cUserType.addItem("Kupac");
        lUserType = new JLabel("Tip korisnika:");
        add(lUserType, "align right");
        add(cUserType);
        bOK = new JButton("OK");
        add(bOK, "span, split 2, sizegroup btn, align center");
        bCancel = new JButton("Cancel");
        add(bCancel, "span, split 2, sizegroup btn, align center");

        bOK.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String usern = tUsername.getText();
                String pass = new String(tPass.getPassword());
                UsersDAO dao = new UsersDAO();
                Users u = dao.loadUserByUsername(usern);

                if(u!=null) {
                    System.out.println(u);
                    try {
                        if(u.getPassword().equals(pass) &&
                                (u.getClass().equals(Class.forName("AllUsers"+(String)cUserType.getSelectedItem())))) {
                            MainFrame mf = new MainFrame();
                            mf.setVisible(true);
                        }else{
                            JOptionPane.showConfirmDialog(thisFrame,"Error2");
                        }
                    } catch (ClassNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }else{
                    JOptionPane.showConfirmDialog(thisFrame,"Error1");
                }
            }
        });
    }

    public static void main(String args []) {
        LoginWindow lw = new LoginWindow();
        lw.setVisible(true);
    }
}
