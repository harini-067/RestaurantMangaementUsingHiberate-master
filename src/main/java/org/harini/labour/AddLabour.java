package org.harini.labour;

import org.harini.model.Labour;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AddLabour extends javax.swing.JFrame {
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField labourNameField;
    private javax.swing.JTextField labourSalaryField;

    public AddLabour() {
        initComponents();
    }

    private void initComponents() {
        addButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labourNameField = new javax.swing.JTextField();
        labourSalaryField = new javax.swing.JTextField();


        labourNameField.setPreferredSize(new java.awt.Dimension(150, 25));
        labourSalaryField.setPreferredSize(new java.awt.Dimension(150, 25));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 255));

        addButton.setText("Add");
        addButton.addActionListener(this::addButtonActionPerformed);

        backButton.setText("Back");
        backButton.addActionListener(this::backButtonActionPerformed);

        jLabel2.setText("Labour Name");
        jLabel3.setText("Labour Salary");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(labourNameField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(labourSalaryField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(172, 172, 172))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(backButton)
                                .addGap(18, 18, 18)
                                .addComponent(addButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(labourNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(labourSalaryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(backButton)
                                        .addComponent(addButton))
                                .addContainerGap(141, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void backButtonActionPerformed(ActionEvent evt) {
        LabourManagement lm = new LabourManagement();
        lm.setVisible(true);
        this.dispose();
    }

    private void addButtonActionPerformed(ActionEvent evt) {
        try {
            String name = labourNameField.getText().trim();
            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Labour Name cannot be empty!", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            double salary;
            try {
                salary = Double.parseDouble(labourSalaryField.getText().trim());
                if (salary <= 0) {
                    throw new NumberFormatException("Salary must be greater than zero.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid salary. Please enter a positive number.", "Validation Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Labour labour = new Labour();
            labour.setName(name);
            labour.setSalary(salary);

            Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Labour.class);
            try (SessionFactory sf = con.buildSessionFactory(); Session session = sf.openSession()) {
                Transaction ts = session.beginTransaction();
                session.persist(labour);
                ts.commit();
                JOptionPane.showMessageDialog(this, "Labour added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
        labourNameField.setText("");
        labourSalaryField.setText("");
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new AddLabour().setVisible(true));
    }
}
