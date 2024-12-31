package com.example.ontime.controller;

import com.example.ontime.service.UserService;
import com.example.ontime.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/", "/home"})
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String email, @RequestParam String password) {
        // For now, accept any login
        return "redirect:/todos";
    }

    @GetMapping("/signup")
    public String showSignupPage(Model model) {
        model.addAttribute("user", new UserDTO());
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignup(@ModelAttribute UserDTO userDTO) {
        userService.addUser(userDTO);
        return "redirect:/login";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable String id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "user";
    }

    @GetMapping("/users/{id}/edit")
    public String showEditUserForm(@PathVariable String id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit-user";
    }

    @PostMapping("/users/{id}/edit")
    public String updateUser(@PathVariable String id, @ModelAttribute UserDTO userDTO) {
        userService.updateUser(id, userDTO);
        return "redirect:/users";
    }

    @PostMapping("/users/{id}/delete")
    public String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
