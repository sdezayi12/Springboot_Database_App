package co2103.hw2.controller;

import co2103.hw2.repo.CafeRepository;
import co2103.hw2.repo.CustomerRepository;
import co2103.hw2.repo.SeatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListController {
    @Autowired
    private CafeRepository CFrepo;
    @Autowired
    private CustomerRepository CTrepo;
    @Autowired
    private SeatingRepository STrepo;

    @GetMapping("/listCafe")
    public String listCafe(Model model) {
        model.addAttribute("data", CFrepo.findAll());
        return "/list";
    }

    @GetMapping("/listSeating")
    public String listSeating(Model model) {
        model.addAttribute("data", STrepo.findAll());
        return "/list";
    }

    @GetMapping("/listCustomer")
    public String listCustomer(Model model) {
        model.addAttribute("data", CTrepo.findAll());
        return "/list";
    }
}
