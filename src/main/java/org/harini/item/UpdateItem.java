package org.harini.item;

import org.harini.model.Item;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class UpdateItem extends javax.swing.JFrame {
    private javax.swing.JButton backButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mName;
    private javax.swing.JTextField mPrice;
    private javax.swing.JTextField mQuantity;
    private javax.swing.JTextField modText;
    private javax.swing.JTextArea text;
    private javax.swing.JButton updateButton;

    public UpdateItem() {
        initComp();
        getAllItems();
    }

    public void initComp() {
        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        modText = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        mName = new javax.swing.JTextField();
        mPrice = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mQuantity = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 153, 255));

        text.setEditable(false);
        text.setBackground(new java.awt.Color(204, 255, 204));
        text.setColumns(20);
        text.setRows(5);
        jScrollPane1.setViewportView(text);

        jLabel1.setText("Enter item Id to update information");
        updateButton.setText("Update");
        updateButton.addActionListener(this::updateButtonActionPerformed);

        backButton.setText("Back");
        backButton.addActionListener(this::backButtonActionPerformed);

        jLabel2.setText("Enter New Name");
        jLabel3.setText("Enter New Price");
        jLabel4.setText("Enter New Quantity");
        jLabel8.setText("ID");
        jLabel5.setText("Name");
        jLabel6.setText("Quantity");
        jLabel7.setText("Price");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8).addGap(79, 79, 79)
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel7)
                                                .addGap(79, 79, 79)
                                                .addComponent(jLabel6)
                                                .addGap(79, 79, 79))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(backButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(updateButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                                                .addGap(40, 40, 40)
                                                .addComponent(mName, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(28, 28, 28)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(modText)
                                                        .addComponent(mPrice)
                                                        .addComponent(mQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(43, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel6))
                                .addGap(3, 3, 3)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(modText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(mName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(mPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(mQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(backButton)
                                        .addComponent(updateButton))
                                .addGap(47, 47, 47))
        );
        pack();
        setLocationRelativeTo(null);
    }

    private void backButtonActionPerformed(ActionEvent evt) {
        ItemManagement im = new ItemManagement();
        this.dispose();
        im.setVisible(true);
    }

    private void updateButtonActionPerformed(ActionEvent evt) {
        if (!isInputValid()) return;

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() {
                try (SessionFactory sf = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Item.class)
                        .buildSessionFactory();
                     Session session = sf.openSession()) {

                    Transaction ts = session.beginTransaction();
                    Item item = session.get(Item.class, modText.getText());
                    if (item == null) {
                        showErrorDialog("Item with ID " + modText.getText() + " not found.");
                        return null;
                    }

                    item.setName(mName.getText());
                    item.setPrice(Double.parseDouble(mPrice.getText()));
                    item.setQuantity(Integer.parseInt(mQuantity.getText()));
                    ts.commit();

                    SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(UpdateItem.this, "Item has been Modified");
                        getAllItems();
                        clearInputs();
                    });

                } catch (Exception ex) {
                    showErrorDialog("An unexpected error occurred: " + ex.getMessage());
                }
                return null;
            }
        };
        worker.execute();
    }


    private boolean isInputValid() {
        if (modText.getText().isEmpty() || mName.getText().isEmpty() ||
                mPrice.getText().isEmpty() || mQuantity.getText().isEmpty()) {
            showErrorDialog("All fields are required.");
            return false;
        }
        try {
            Double.parseDouble(mPrice.getText());
            Integer.parseInt(mQuantity.getText());
        } catch (NumberFormatException ex) {
            showErrorDialog("Price and Quantity must be valid numbers.");
            return false;
        }
        return true;
    }

    public static void showErrorDialog(String message) {
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
        });
    }

    private void clearInputs() {
        modText.setText("");
        mName.setText("");
        mPrice.setText("");
        mQuantity.setText("");
    }

    private void getAllItems() {
        List<Item> item = ItemService.getAllItems();
//        System.out.println(item);
        StringBuilder fullnames = new StringBuilder();
        for (Item items : item){
            fullnames.append(items.getId()).append("\t").append(items.getName()).append("\t").append("\t").append(items.getPrice()).append("\t").append(items.getQuantity()).append("\n");
        }
        text.setText(fullnames.toString());
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new UpdateItem().setVisible(true));
    }
}
