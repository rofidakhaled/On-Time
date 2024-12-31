package com.example.ontime.controller;

import com.example.ontime.service.ToDoService;
import com.example.ontime.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import com.example.ontime.service.UserService;
import com.example.ontime.model.dto.UserDTO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.ontime.entity.User;

@Controller
@RequestMapping("/UserProfile")
public class UserController {

    @GetMapping("/")
    public String redirectToSignup() {
        return "redirect:/UserProfile/signup";
    }

    private final UserService userService;
    private final UserRepository userRepository;
    private final ToDoService toDoService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository, ToDoService toDoService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.userRepository = userRepository;
        this.toDoService = toDoService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/signup")
    public String showAddUserForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "signup";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute UserDTO userDTO) {
        userService.addUser(userDTO);
        return "redirect:/UserProfile";
    }

    @GetMapping("/edit/{Id}")
    public String showEditUserForm(@PathVariable String Id, Model model) {
        userService.getUserById(Id).ifPresent(user -> model.addAttribute("user", user));
        return "edit-user";
    }

    @PostMapping("/edit/{Id}")
    public String updateUser(@PathVariable String Id, @ModelAttribute UserDTO userDTO) {
        userService.updateUser(Id, userDTO);
        return "redirect:/UserProfile";
    }

    @GetMapping("/delete/{Id}")
    public String deleteUser(@PathVariable String Id) {
        userService.deleteUser(Id);
        return "redirect:/UserProfile";
    }

    @PostMapping("/signup")
    public String signUp(@RequestParam String email, @RequestParam String password, @RequestParam String name) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(passwordEncoder.encode(password)); // Encoding the password
        userRepository.save(user);
        return "redirect:/UserProfile/login"; // Redirect to login page after signup
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Return the login page
    }

    @GetMapping("/todos")
    public String getUserToDos(Model model, @AuthenticationPrincipal User loggedInUser) {
        String userId = loggedInUser.getId();
        model.addAttribute("todos", toDoService.getToDosForUser(Integer.parseInt(userId))); // Fetching ToDos for the logged-in user
        return "todos"; // Return the ToDos page
    }
}
