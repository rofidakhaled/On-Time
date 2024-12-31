package com.example.ontime.controller;

import com.example.ontime.service.ToDoService;
import com.example.ontime.model.dto.ToDoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.ontime.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/todos")
public class ToDoController {

    @Autowired
    private ToDoService todoService;

    @GetMapping("/todos")
    public String getUserToDos(Model model, @AuthenticationPrincipal User loggedInUser) {
        String userId = loggedInUser.getId();
        model.addAttribute("toDos", todoService.getToDosForUser(Integer.parseInt(userId)));  // Pass the ToDos for the logged-in user
        return "todos";  // Return the view that displays the ToDos
    }

    @GetMapping
    public String getAllToDos(Model model) {
        model.addAttribute("todos", todoService.getAllToDos());
        return "todos";
    }

    @GetMapping("/add")
    public String showAddToDoForm(Model model) {
        model.addAttribute("todo", new ToDoDTO());
        return "add-todo";
    }

    @PostMapping("/add")
    public String addToDo(@ModelAttribute ToDoDTO todoDTO) {
        todoService.addToDo(todoDTO);
        return "redirect:/todos";
    }

    @GetMapping("/edit/{taskId}")
    public String showEditToDoForm(@PathVariable int taskId, Model model) {
        todoService.getToDoById(taskId).ifPresent(todo -> model.addAttribute("ToDo", todo));
        return "edit-todo";
    }

    @PostMapping("/edit/{taskId}")
    public String updateToDo(@PathVariable int taskId, @ModelAttribute ToDoDTO todoDTO) {
        todoService.updateToDo(taskId, todoDTO);
        return "redirect:/todos";
    }

    @GetMapping("/delete/{taskId}")
    public String deleteToDo(@PathVariable String taskId) {
        todoService.deleteToDo(taskId);
        return "redirect:/todos";
    }
}

