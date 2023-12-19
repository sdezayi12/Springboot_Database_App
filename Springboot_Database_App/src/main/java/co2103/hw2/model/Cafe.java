package co2103.hw2.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cafe {
    @Id
    @GeneratedValue
    private int id;
    private String address;
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<Seating> seatings;
    @ManyToOne(cascade = CascadeType.ALL)
    private Seating best;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Seating> getSeatings() {
        return seatings;
    }

    public void setSeatings(List<Seating> seatings) {
        this.seatings = seatings;
    }

    public Seating getBest() {
        return best;
    }

    public void setBest(Seating best) {
        this.best = best;
    }

    @Override
    public String toString() {
        return "Cafe{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", seatings=" + seatings +
                ", best=" + best +
                '}';
    }
}
