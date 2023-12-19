package co2103.hw2.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Seating {
    @Id
    private String location;
    @ManyToMany(mappedBy = "seatings")
    private List<Cafe> cafes;
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @JoinColumn
    private List <Customer> customers;
    @OneToOne(orphanRemoval = true)
    private Customer reviewer;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Cafe> getCafes() {
        return cafes;
    }

    public void setCafes(List<Cafe> cafes) {
        this.cafes = cafes;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public Customer getReviewer() {
        return reviewer;
    }

    public void setReviewer(Customer reviewer) {
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        return "Seating{" +
                "location='" + location + '\'' +
                ", customers=" + customers +
                ", reviewer=" + reviewer +
                '}';
    }
}
