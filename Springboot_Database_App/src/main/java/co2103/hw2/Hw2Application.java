package co2103.hw2;

import co2103.hw2.model.Cafe;
import co2103.hw2.model.Customer;
import co2103.hw2.model.Seating;
import co2103.hw2.repo.CafeRepository;
import co2103.hw2.repo.CustomerRepository;
import co2103.hw2.repo.SeatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Hw2Application implements CommandLineRunner {

    @Autowired
    private CafeRepository CFrepo;
    @Autowired
    private CustomerRepository CTrepo;
    @Autowired
    private SeatingRepository STrepo;

    public static List<Cafe> cafes = new ArrayList<>();
    public static void main(String[] args) {
        SpringApplication.run(Hw2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Cafe cf1 = new Cafe();
        cf1.setAddress("29 Jump Street");
        cf1 = CFrepo.save(cf1);

        Customer ct1 = new Customer();
        ct1.setOrders(21);
        ct1 = CTrepo.save(ct1);

        Seating st1 = new Seating();
        st1.setLocation("London");
        st1 = STrepo.save(st1);

        cf1.setSeatings(new ArrayList<>());
        cf1.getSeatings().add(st1);
        cf1.setBest(st1);
        CFrepo.save(cf1);

        st1.setCafes(new ArrayList<>());
        st1.getCafes().add(cf1);
        st1.setCustomers(new ArrayList<>());
        st1.getCustomers().add(ct1);
        st1.setReviewer(ct1);
        STrepo.save(st1);

    }
}