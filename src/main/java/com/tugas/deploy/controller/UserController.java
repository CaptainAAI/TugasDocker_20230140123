package com.tugas.deploy.controller;

import com.tugas.deploy.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    private final String USERNAME = "admin";
    private final String PASSWORD = "20230140123";
    private final List<User> temporaryUsers = new ArrayList<>();

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String username, String password, Model model) {
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }

    }

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("homes", temporaryUsers);
        return "home";
    }

    @GetMapping("/form")
    public String formPage(Model model) {
        model.addAttribute("temporaryUsers", temporaryUsers);
        return "form";
    }

    @PostMapping("/form")
    public String saveForm(@RequestParam String nama,
                           @RequestParam String nim,
                           @RequestParam String jenisKelamin) {
        int no = temporaryUsers.size() + 1;
        temporaryUsers.add(new User(no, nama, nim, jenisKelamin));
        return "redirect:/home";
    }
}