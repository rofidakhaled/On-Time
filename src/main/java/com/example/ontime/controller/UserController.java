package com.example.ontime.controller;

import com.example.ontime.service.UserService;
import com.example.ontime.model.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/UserProfile")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/add")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "add-user";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute UserDTO userDTO) {
        userService.addUser(userDTO);
        return "redirect:/users";
    }

    @GetMapping("/edit/{Id}")
    public String showEditUserForm(@PathVariable String Id, Model model) {
        userService.getUserById(Id).ifPresent(user -> model.addAttribute("user", user));
        return "edit-user";
    }

    @PostMapping("/edit/{Id}")
    public String updateUser(@PathVariable String Id, @ModelAttribute UserDTO userDTO) {
        userService.updateUser(Id, userDTO);
        return "redirect:/users";
    }

    @GetMapping("/delete/{Id}")
    public String deleteUser(@PathVariable String Id) {
        userService.deleteUser(Id);
        return "redirect:/users";
    }
}
