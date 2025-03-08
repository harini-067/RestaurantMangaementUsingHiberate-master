package org.harini.labour;

import org.harini.model.Labour;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import static org.harini.item.UpdateItem.showErrorDialog;

import java.awt.event.ActionEvent;
import java.util.List;

public class ViewLabour extends javax.swing.JFrame {
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea text;

    public ViewLabour(){
        initComponents();
        getAllLabours();
    }
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 204));

        text.setEditable(false);
        text.setColumns(20);
        text.setRows(5);
        jScrollPane1.setViewportView(text);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("iD");

        jLabel2.setText("Name");

        jLabel3.setText("Salary");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(315, 315, 315)
                                                .addComponent(backButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(54, 54, 54)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(71, 71, 71)
                                                .addComponent(jLabel1)
                                                .addGap(64, 64, 64)
                                                .addComponent(jLabel2)
                                                .addGap(49, 49, 49)
                                                .addComponent(jLabel3)))
                                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addGap(5, 5, 5)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(backButton)
                                .addGap(50, 50, 50))
        );

        pack();
        setLocationRelativeTo(null);
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
        java.awt.EventQueue.invokeLater(() -> new ViewLabour().setVisible(true));
    }

}
