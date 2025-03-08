package org.harini.labour;

import org.harini.item.DeleteItem;
import org.harini.item.UpdateItem;
import org.harini.model.Item;
import org.harini.model.Labour;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.swing.*;

import static org.harini.item.UpdateItem.showErrorDialog;

import java.awt.event.ActionEvent;
import java.util.List;

public class DeleteLabour extends javax.swing.JFrame {

    public DeleteLabour(){
        initComponents();
        getAllLabours();
    }
    private javax.swing.JButton backButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField labourIDField;
    private javax.swing.JTextArea text;
    private void initComponents() {


        deleteButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        labourIDField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 255));

        deleteButton.setText("Delete");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        text.setEditable(false);
        text.setColumns(20);
        text.setRows(5);
        jScrollPane1.setViewportView(text);

        jLabel1.setText("Which Labour ID  want to Delete");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(deleteButton)
                                .addGap(18, 18, 18)
                                .addComponent(backButton)
                                .addGap(57, 57, 57))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(47, 47, 47)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(labourIDField, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(60, 60, 60)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(labourIDField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(deleteButton)
                                        .addComponent(backButton))
                                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
        getAllLabours();
    }

    private void deleteButtonActionPerformed(ActionEvent evt) {
        String id = labourIDField.getText();
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Labour.class);
        try (SessionFactory sf = con.buildSessionFactory();
             Session session = sf.openSession()) {
            Transaction ts = session.beginTransaction();
            Labour lab = session.load(Labour.class,id);
            session.delete(lab);
            ts.commit();
            JOptionPane.showMessageDialog(this, "Labour has been deleted");
            labourIDField.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Please eneter a valid ID to delete");
            throw new RuntimeException(e);
        }
        getAllLabours();
    }

    private void backButtonActionPerformed(ActionEvent evt) {
        LabourManagement lm = new LabourManagement();
        lm.setVisible(true);
        this.dispose();
    }
    private void getAllLabours(){
        List<Labour> labour = LabourServices.getAllItems();
        StringBuilder fullnames = new StringBuilder();
        for (Labour lab : labour){
            fullnames.append(lab.getId()).append("\t").append(lab.getName()).append("\t").append(lab.getSalary()).append("\n");
        }
        text.setText(fullnames.toString());
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new DeleteLabour().setVisible(true));
    }
}
