package org.harini.labour;

import jakarta.persistence.EntityManager;

import org.harini.model.Labour;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class UpdateLabour extends javax.swing.JFrame{



    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
//    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
//    private javax.swing.JTextField newLabourIDField;
    private javax.swing.JTextField newLabourNameField;
    private javax.swing.JTextField newLabourSalaryField;
    private javax.swing.JTextField oldLabourIdField;
    private javax.swing.JTextArea text;
    private javax.swing.JButton updateButton;
    //private EntityManager entityManager;

    public UpdateLabour(){
//        LabourServices ls = new LabourServices();
        initComponents();
        getAllLabours();

    }

    private void getAllLabours(){
        List<Labour> labour = LabourServices.getAllItems();
        StringBuilder fullnames = new StringBuilder();
        for (Labour lab : labour){
            fullnames.append(lab.getId()).append("\t").append(lab.getName()).append("\t").append(lab.getSalary()).append("\n");
        }
        text.setText(fullnames.toString());
    }

    private void initComponents() {

        newLabourNameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        newLabourSalaryField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        oldLabourIdField = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
//        jLabel2 = new javax.swing.JLabel();
//        newLabourIDField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 255));

        jLabel3.setText("Enter New Name");

        text.setEditable(false);
        text.setColumns(20);
        text.setRows(5);
        jScrollPane1.setViewportView(text);

        jLabel4.setText("Enter New Salary");

        jLabel1.setText("Which labour id want to modify");

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

//        jLabel2.setText("Enter New ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(61, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                                                                .addComponent(updateButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(backButton))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addGroup(layout.createSequentialGroup()
//                                                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGap(40, 40, 40))
//                                                                        .addComponent(newLabourIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addGap(28, 28, 28)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(oldLabourIdField)
                                                                                .addComponent(newLabourNameField)
                                                                                .addComponent(newLabourSalaryField, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addContainerGap())
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(51, 51, 51))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(oldLabourIdField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE))
//                                        .addComponent(newLabourIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(newLabourNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(newLabourSalaryField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(updateButton)
                                        .addComponent(backButton))
                                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();

    }

    private void backButtonActionPerformed(ActionEvent evt) {
        LabourManagement lm = new LabourManagement();
        lm.setVisible(true);
        this.dispose();

    }

    private void updateButtonActionPerformed(ActionEvent evt) {

        int id = Integer.parseInt(oldLabourIdField.getText());
        String name = newLabourNameField.getText();
        double salary = Integer.parseInt(newLabourSalaryField.getText());
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Labour.class);
        try (SessionFactory sf = con.buildSessionFactory(); Session session = sf.openSession()) {
            Transaction ts = session.beginTransaction();
            Labour labour = session.load(Labour.class,id);
//            Labour labour = entityManager.find(Labour.class,id);
            labour.setName(name);
            labour.setSalary(salary);
            ts.commit();
            JOptionPane.showMessageDialog(this, "Labour Updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            getAllLabours();
            newLabourNameField.setText("");
            newLabourSalaryField.setText("");
            oldLabourIdField.setText("");
        }
     catch(Exception e) {
        JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
    }



    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new UpdateLabour().setVisible(true));
    }
}
