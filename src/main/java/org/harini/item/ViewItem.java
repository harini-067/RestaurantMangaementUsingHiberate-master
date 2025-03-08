package org.harini.item;

import java.awt.event.ActionEvent;
import java.util.List;

import org.harini.model.Item;

public class ViewItem extends javax.swing.JFrame{
    public ViewItem(){
        initComponents();
        getAllItem();

    }
    private void getAllItem(){
        List<Item> items = ItemService.getAllItems();

        StringBuilder fullnames = new StringBuilder();
        for (Item item : items) {
            fullnames.append(String.format("%-5d %-15s %-10.2f %-10d\n",
                    item.getId(), item.getName(), item.getPrice(), item.getQuantity()));
        }
        text.setText(fullnames.toString());

    }
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea text;
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 255));

        text.setBackground(new java.awt.Color(204, 255, 204));
        text.setColumns(20);
        text.setRows(5);
        jScrollPane1.setViewportView(text);

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Name");

        jLabel2.setText("Price");

        jLabel3.setText("Quantity");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(300, 300, 300)
                                                .addComponent(backButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(53, 53, 53)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(9, 9, 9)
                                                                .addComponent(jLabel1)
                                                                .addGap(54, 54, 54)
                                                                .addComponent(jLabel2)
                                                                .addGap(63, 63, 63)
                                                                .addComponent(jLabel3)))))
                                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(28, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(backButton)
                                .addGap(50, 50, 50))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void backButtonActionPerformed(ActionEvent evt) {
        ItemManagement im = new ItemManagement();
        im.setVisible(true);
        this.setVisible(false);
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewItem().setVisible(true);
            }
        });
    }
}
