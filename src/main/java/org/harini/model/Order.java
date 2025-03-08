package org.harini.model;

public class Order {

    private int orderId;

    private double price;

    private String date;

    public Order(int orderId, double price, String date) {
        this.orderId = orderId;
        this.price = price;
        this.date = date;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
