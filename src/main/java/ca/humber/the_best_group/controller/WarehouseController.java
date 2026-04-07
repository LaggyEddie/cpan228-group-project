package ca.humber.the_best_group.controller;

import ca.humber.the_best_group.beans.Product;
import ca.humber.the_best_group.model.Contact;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WarehouseController {

    @GetMapping("/")
    public String index() {
        return "home";
    }

    @GetMapping("/inventory")
    public String inventory(Model model) {
        List<Product> products = new ArrayList<>(); 
        model.addAttribute("products", products);
        model.addAttribute("product", new Product());
        return "inventory/list";
    }

    @GetMapping("/management")
    public String management() {
        return "management/dashboard";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    @GetMapping("/permission-denied")
    public String permissionDenied() {
        return "error/permission-denied";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/contact")
    public String contactPage(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContact(@ModelAttribute Contact contact, Model model) {
        model.addAttribute("message", "Message received successfully!");
        return "contact";
    }
    
    @PostMapping("/insertProduct")
    public String insertProduct(@ModelAttribute Product product) {
        return "redirect:/inventory";
    }
}