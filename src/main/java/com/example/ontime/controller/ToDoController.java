package com.example.ontime.controller;

import com.example.ontime.service.ToDoService;
import com.example.ontime.model.dto.ToDoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 
 */
@Controller
@RequestMapping("/todos")
public class ToDoController {

    @Autowired
    private ToDoService todoService;

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
    public String showEditToDoForm(@PathVariable String taskId, Model model) {
        todoService.getToDoById(Integer.parseInt(taskId)).ifPresent(todo -> model.addAttribute("todo", todo));
        return "edit-todo";
    }

    @PostMapping("/edit/{taskId}")
    public String updateToDo(@PathVariable String taskId, @ModelAttribute ToDoDTO todoDTO) {
        todoService.updateToDo(Integer.parseInt(taskId), todoDTO);
        return "redirect:/todos";
    }

    @GetMapping("/delete/{taskId}")
    public String deleteToDo(@PathVariable String taskId) {
        todoService.deleteToDo(taskId);
        return "redirect:/todos";
    }
}
