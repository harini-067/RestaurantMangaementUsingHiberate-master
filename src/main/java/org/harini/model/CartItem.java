package org.harini.model;

import jakarta.persistence.*;

@Entity
@Table(name = "CartItem")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false) // Foreign key to Cart table
    private Cart cart; // This field connects CartItem to Cart

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false) // Foreign key to Item table
    private Item item;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private double price;

    public CartItem(Item item, int quantity, double price) {
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
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
