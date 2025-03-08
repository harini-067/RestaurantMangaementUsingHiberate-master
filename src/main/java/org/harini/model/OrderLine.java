package org.harini.model;
import jakarta.persistence.*;


@Entity
@Table(name = "Orders")
public class OrderLine {
    @Id
    @Column(name = "id")
    private int id;

//    @ManyToOne
//    @JoinColumn(name = "order_id") // Ensure this column matches the foreign key column in the database
//    private Order order;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double price;

    public OrderLine(int orderID, String name, int quantity, double price) {
        this.id = orderID;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getOrderID() {
        return id;
    }

    public void setOrderID(int orderID) {
        this.id = orderID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
