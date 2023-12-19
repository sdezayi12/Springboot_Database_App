package co2103.hw2.controller;

import co2103.hw2.model.Cafe;
import co2103.hw2.model.Customer;
import co2103.hw2.model.Seating;
import co2103.hw2.repo.CafeRepository;
import co2103.hw2.repo.CustomerRepository;
import co2103.hw2.repo.SeatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class DeleteController {
    @Autowired
    private CafeRepository CFrepo;
    @Autowired
    private CustomerRepository CTrepo;
    @Autowired
    private SeatingRepository STrepo;

    @GetMapping("/deleteCafe")
    public String deleteCafe(@RequestParam int id) {
        CFrepo.deleteById(id);
        return "redirect:";
    }

    @GetMapping("/deleteSeating")
    public String deleteSeating(@RequestParam String location) {
        List<Cafe> bestLocation = CFrepo.findByBest_Location(location);
        for (Cafe cafe: bestLocation) {
            if (cafe.getBest().getLocation().equals(location)) {
                cafe.setBest(null);
                CFrepo.save(cafe);
            }
        }
        Optional<Seating> seatingOptional = STrepo.findById(location);
        for (Cafe cafe: CFrepo.findAll()) {
            if (cafe.getSeatings().contains(seatingOptional.get())) {
                cafe.getSeatings().remove(seatingOptional.get());
            }
        }
        STrepo.deleteById(location);
        return "redirect:";

    }

    @GetMapping("/deleteCustomer")
    public String deleteCustomer(@RequestParam int identifier) {
        List<Customer> customers= CTrepo.findCustomersByIdentifier(identifier);
        for (Customer customer: customers
             ) {
            List<Seating> seatings = STrepo.findSeatingByReviewer(customer);
            for (Seating seating: seatings) {
                seating.setReviewer(null);
                STrepo.save(seating);
            }

        }
        for (Seating s: STrepo.findAll())
        {
            for (Customer c: customers) {
                if (s.getCustomers().contains(c))  {
                    int index = s.getCustomers().indexOf(c);
                    s.getCustomers().remove(index);
                }
            }
            STrepo.save(s);
        }
        CTrepo.deleteById(identifier);
        return "redirect:";
    }
}

