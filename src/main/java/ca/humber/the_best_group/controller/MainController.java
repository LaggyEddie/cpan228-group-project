package ca.humber.thebestgroup.controller;

import ca.humber.thebestgroup.model.Contact;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    // HOME
    @GetMapping("/")
    public String homepage() {
        return "home";
    }

    // ABOUT
    @GetMapping("/about")
    public String aboutpage() {
        return "about";
    }

    // CONTACT PAGE (GET)
    @GetMapping("/contact")
    public String contactpage(Model model) {
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    // CONTACT FORM (POST)
    @PostMapping("/contact")
    public String submitContact(@ModelAttribute Contact contact, Model model) {

        // Just simulate success (no email)
        model.addAttribute("message", "Message received successfully!");

        // Optional: print in console (for testing)
        System.out.println("Name: " + contact.getName());
        System.out.println("Email: " + contact.getEmail());
        System.out.println("Subject: " + contact.getSubject());
        System.out.println("Message: " + contact.getMessage());

        return "contact";
    }
}