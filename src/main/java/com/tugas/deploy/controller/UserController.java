package com.tugas.deploy.controller;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final String USERNAME = "admin";
    private final String PASSWORD = "20230140123";

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password, Model model) {
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            return "home";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }

    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }
}