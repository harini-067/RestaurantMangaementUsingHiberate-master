package org.harini;
import org.harini.item.ViewItem;
import org.harini.model.Admin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends javax.swing.JFrame{
    public Login(){
        initComp();
        setDefaultUserName();
    }
    JTextField emailField = new JTextField();
    JTextField idField = new JTextField();
    JTextField phoneField = new JTextField();

    private void setDefaultUserName() {
        this.idField.setText("102");
        this.emailField.setText("tester1@gmail.com");
        this.phoneField.setText("tester1");
    }

    private void initComp(){
        JFrame f = new JFrame("Customer Login");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel l3 = new JLabel("Id:");
        l3.setBounds(30, 25, 100, 30);
//        JTextField idField = new JTextField();
        idField.setBounds(150, 25, 200, 30);
        //summa
        JLabel l1 = new JLabel("Email:");
        l1.setBounds(30, 70, 100, 30);
//        JTextField emailField = new JTextField();
        emailField.setBounds(150, 70, 200, 30);

        JLabel l2 = new JLabel("Password:");
        l2.setBounds(30, 120, 100, 30);
//        JTextField phoneField = new JTextField();
        phoneField.setBounds(150, 120, 200, 30);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(150, 170, 100, 30);
        f.add(l3);
        f.add(idField);
        f.add(l1);
        f.add(emailField);
        f.add(l2);
        f.add(phoneField);
        f.add(loginButton);

        f.setSize(400, 250);
        f.setLayout(null);
        f.setVisible(true);

        // Handle login logic
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = phoneField.getText();
                int id = Integer.parseInt(idField.getText());
                if (isValidLogin(email, password,id)) {
                    JOptionPane.showMessageDialog(f, "Login successful!");
                    f.setVisible(false);
//                    this.dispose();
                    MainMenu mainMenu = new MainMenu();
                    mainMenu.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(f, "Invalid credentials. Please try again.");
                }
            }
        });
    }

    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });

    }

    private boolean isValidLogin(String email, String password, int id) {
        Admin obj1 = new Admin();

        Configuration con = new Configuration().configure().addAnnotatedClass(Admin.class);
        SessionFactory sf = con.buildSessionFactory();
        Session ses = sf.openSession();
        Transaction ts = ses.beginTransaction();
        obj1 = ses.get(Admin.class,id);
        ts.commit();
        if (obj1!=null && obj1.getPassword().equals(password) && obj1.getEmail().equals(email)){

            return true;
        }


        return false;

  }


}
