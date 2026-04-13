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
        List<User> homes = List.of(
                new User(1, "Andi Saputra", "20230140101", "Laki-laki"),
                new User(2, "Siti Aisyah", "20230140102", "Perempuan")
        );
        model.addAttribute("homes", homes);
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
                           @RequestParam String jenisKelamin,
                           Model model) {
        int no = temporaryUsers.size() + 1;
        temporaryUsers.add(new User(no, nama, nim, jenisKelamin));
        model.addAttribute("temporaryUsers", temporaryUsers);
        model.addAttribute("success", "Data mahasiswa berhasil ditambahkan sementara");
        return "form";
    }
}