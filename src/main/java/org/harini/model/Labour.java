package org.harini.model;


import jakarta.persistence.*;

@Entity
public class Labour {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
   private String name;
    @Column(nullable = false)
   private double salary;

    public Labour(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public Labour() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
