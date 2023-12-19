package co2103.hw2.model;

import jakarta.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue
    private int identifier;
    private int orders;


    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "identifier=" + identifier +
                ", orders=" + orders +
                '}';
    }
}
