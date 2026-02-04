package ca.humber.thebestgroup.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
    @GetMapping("/")
    public String homepage() {
        return "home.html";
    }

    @GetMapping("/about")
    public String aboutpage() {
        return "about.html";
    }

    @GetMapping("/contact")
    public String contactpage() {
        return "contact.html";
    }
}
