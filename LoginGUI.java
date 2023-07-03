/*
 * Main.java
 * this is the main class
 * Author M.Zaihd Behardien(219233829)
 * 23 August 2022
 */
package za.ac.cput.adploginapp;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author zaihd
 */
public class LoginGUI extends JFrame implements ActionListener {
    private JPanel panelWest, panelEast, panelSouth;
    private JLabel lblEmail;
    private JLabel lblPassword;
    private JTextField txtEmail;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JButton btnCancel;

    public LoginGUI() {
        super("User Authentication");
        panelWest = new JPanel();
        panelEast = new JPanel();
        panelSouth = new JPanel();
        lblEmail = new JLabel("Email");
        lblPassword = new JLabel("Password");
        txtEmail = new JTextField();
        txtPassword = new JPasswordField();
        btnLogin = new JButton("Login");
        btnCancel = new JButton("Cancel");
    }

    public void setGUI() {
        panelWest.setLayout(new GridLayout(2, 1));
        panelEast.setLayout(new GridLayout(2, 1));
        panelSouth.setLayout(new GridLayout(1, 2));
        panelEast.setPreferredSize(new Dimension(250, 90));
        panelSouth.setPreferredSize(new Dimension(200, 20));
        panelWest.add(lblEmail);
        panelWest.add(lblPassword);
        panelEast.add(txtEmail);
        panelEast.add(txtPassword);
        panelSouth.add(btnLogin);
        panelSouth.add(btnCancel);

        this.add(panelWest, BorderLayout.WEST);
        this.add(panelEast, BorderLayout.EAST);
        this.add(panelSouth, BorderLayout.SOUTH);

        btnLogin.addActionListener(this);
        btnCancel.addActionListener(this);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(400, 150); // Set the size explicitly
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            String email = txtEmail.getText();
            String password = String.valueOf(txtPassword.getPassword());
            User u = new User(email, password);
            if (UserDAO.authentication(u)) {
                JOptionPane.showMessageDialog(this, "Welcome " + u.getTitles() + " " + u.getFirstName());
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(this, "The email and/or password is incorrect");
                txtEmail.requestFocus(); // Use requestFocus() instead of hasFocus()
            }
        } else if (e.getSource() == btnCancel) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        LoginGUI loginGUI = new LoginGUI();
        loginGUI.setGUI();
    }
}
