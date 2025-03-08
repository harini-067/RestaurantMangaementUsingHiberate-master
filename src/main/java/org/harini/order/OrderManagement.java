package org.harini.order;

import org.harini.MainMenu;
import org.harini.item.ItemService;
import org.harini.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OrderManagement extends javax.swing.JFrame{

    public OrderManagement(){
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

    private javax.swing.JButton addToCartButton;
    private javax.swing.JButton backButton;
    private javax.swing.JButton clearCartButton;
    private javax.swing.JTextField itemIDToOrderField;
    private javax.swing.JTextField itemOrderQuantityField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton orderButton;
    private javax.swing.JTextArea reciptArea;
    private javax.swing.JTextArea text;
    private javax.swing.JTextField totalPriceField;

    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        itemOrderQuantityField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        addToCartButton = new javax.swing.JButton();
        itemIDToOrderField = new javax.swing.JTextField();
        orderButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        reciptArea = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        totalPriceField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        clearCartButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        text.setEditable(false);
        text.setBackground(new java.awt.Color(204, 204, 204));
        text.setColumns(20);
        text.setRows(5);
        jScrollPane1.setViewportView(text);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setText("Which ID Item You want?");

        jLabel4.setText("Enter  Quantity");

        addToCartButton.setText("Add to cart");
        addToCartButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToCartButtonActionPerformed(evt);
            }
        });

        orderButton.setText("Order");
        orderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(addToCartButton))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(itemOrderQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 235, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(itemIDToOrderField, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(39, 39, 39)
                                .addComponent(orderButton)
                                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap(52, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(itemIDToOrderField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(itemOrderQuantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addComponent(orderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(5, 5, 5)))
                                .addComponent(addToCartButton)
                                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(backButton)
                                                .addGap(201, 492, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(12, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(backButton)
                                .addGap(23, 23, 23))
        );

        reciptArea.setBackground(new java.awt.Color(255, 153, 102));
        reciptArea.setColumns(20);
        reciptArea.setRows(5);
        jScrollPane2.setViewportView(reciptArea);

        jLabel2.setText("Name");

        jLabel3.setText("Price");

        jLabel5.setText("Quantity");

        totalPriceField.setEditable(false);
        totalPriceField.setBackground(new java.awt.Color(255, 204, 51));

        jLabel6.setText("ID");

        jLabel8.setText("Price");

        jLabel7.setText("Quantity");

        jLabel10.setText("Name");

        clearCartButton.setText("Cancel");
        clearCartButton.addActionListener(this::clearCartButtonActionPerformed);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addGap(92, 92, 92)
                                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(39, 39, 39)
                                                                .addComponent(jLabel3)
                                                                .addGap(48, 48, 48)
                                                                .addComponent(jLabel5))
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel6))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                                        .addGap(2, 2, 2)
                                                                        .addComponent(jLabel10)
                                                                        .addGap(40, 40, 40)
                                                                        .addComponent(jLabel7)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGap(28, 28, 28))
                                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(totalPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(clearCartButton)))
                                                .addGap(40, 40, 40)))
                                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(jLabel3)
                                                        .addComponent(jLabel5)
                                                        .addComponent(jLabel6)
                                                        .addComponent(jLabel10))
                                                .addGap(6, 6, 6)
                                                .addComponent(jScrollPane1))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel8)
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(totalPriceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(clearCartButton))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }
    private void quanUpdate(){
        int id = Integer.parseInt(itemIDToOrderField.getText());
        int quan = Integer.parseInt(itemOrderQuantityField.getText());
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Labour.class);
        try (SessionFactory sf = con.buildSessionFactory(); Session session = sf.openSession()) {
            Transaction ts = session.beginTransaction();
            Item something = session.load(Item.class,id);
            int newQuan =  something.getQuantity();
             something.setQuantity(newQuan-quan);
            ts.commit();
            getAllItem();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    double totalPrice;

    private void addToCartButtonActionPerformed(ActionEvent evt) {
        int id = Integer.parseInt(itemIDToOrderField.getText());
        int quan = Integer.parseInt(itemOrderQuantityField.getText());
        Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Labour.class);
        try (SessionFactory sf = con.buildSessionFactory(); Session session = sf.openSession()) {
            Transaction ts = session.beginTransaction();
            Item something = session.load(Item.class,id);
            totalPrice += something.getPrice() * quan;
            quanUpdate();
            StringBuilder receipt = new StringBuilder(reciptArea.getText());
            receipt.append(something.getName())
                    .append("\t")
                    .append(quan)
                    .append("\t")
                    .append(something.getPrice() * quan)
                    .append("\n");
            reciptArea.setText(receipt.toString());
            totalPriceField.setText(String.valueOf(totalPrice));
            ts.commit();
            JOptionPane.showMessageDialog(this, "Item Added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            itemIDToOrderField.setText("");
            itemOrderQuantityField.setText("");
        } catch (NumberFormatException exception){
            JOptionPane.showMessageDialog(this, "An error occurred: " + exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            exception.printStackTrace();
        }catch (NullPointerException np){
            JOptionPane.showMessageDialog(this, "An error occurred: " + np.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            np.printStackTrace();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(this, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }

    private void orderButtonActionPerformed(ActionEvent evt) {
        String invoiceDirectory = "D:\\JavaProjectByMe\\RestaurantMangaementUsingHiberate\\invoice";
        String invoiceFileName = "Invoice_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".txt";
        String filePath = invoiceDirectory + "\\" + invoiceFileName;

        // Create the invoice content
        String invoiceContent = "Invoice\n" +
                "Date: " + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()) + "\n" +
                "---------------------------------------\n" +
                reciptArea.getText() +
                "---------------------------------------\n" +
                "Total Price: " + totalPriceField.getText() + "\n" +
                "---------------------------------------\n" +
                "Thank you for your order!";

        try {
            // Ensure the directory exists
            java.nio.file.Files.createDirectories(java.nio.file.Paths.get(invoiceDirectory));

            // Write the content to the file
            try (PrintWriter writer = new PrintWriter(new FileOutputStream(filePath))) {
                writer.print(invoiceContent);
            }

            // Inform the user and display the invoice content
            JOptionPane.showMessageDialog(this, "Invoice saved to:\n" + filePath, "Invoice Generated", JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Invoice content:\n" + invoiceContent);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error saving the invoice: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }


    private void clearCartButtonActionPerformed(ActionEvent evt) {
        reciptArea.setText("");
        totalPriceField.setText("");
    }

    private void backButtonActionPerformed(ActionEvent evt) {
        MainMenu mm =new MainMenu();
        mm.setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new OrderManagement().setVisible(true));
    }
}
