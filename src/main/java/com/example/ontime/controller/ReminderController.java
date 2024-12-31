package com.example.ontime.controller;

import com.example.ontime.model.dto.ReminderDTO;
import com.example.ontime.entity.Reminder;
import com.example.ontime.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Controller
@RequestMapping("/reminders")
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

    @GetMapping
    public String getAllReminders(Model model) {
        model.addAttribute("reminders", reminderService.getAllReminders());
        return "reminders";
    }

    @GetMapping("/add")
    public String showAddReminderForm(Model model) {
        model.addAttribute("reminder", new Reminder());
        return "add-reminder";
    }

    @PostMapping("/add")
    public String addReminder(
            @RequestParam String name,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date reminderDateTime,
            @RequestParam(required = false) String recurrence,
            RedirectAttributes redirectAttributes) {
        Reminder reminder = new Reminder();
        reminder.setName(name);
        reminder.setReminderDateTime(reminderDateTime);
        reminder.setRecurrence(recurrence);
        ReminderDTO savedReminder = reminderService.addReminder(reminder);
        
        String message = "New reminder '" + name + "' created for " + 
                        new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm").format(reminderDateTime);
        redirectAttributes.addAttribute("notification", URLEncoder.encode(message, StandardCharsets.UTF_8));
        return "redirect:/reminders";
    }

    @GetMapping("/edit/{id}")
    public String showEditReminderForm(@PathVariable Long id, Model model) {
        model.addAttribute("reminder", reminderService.getReminderById(id));
        return "edit-reminder";
    }

    @PostMapping("/edit/{id}")
    public String updateReminder(
            @PathVariable Long id,
            @RequestParam String name,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Date reminderDateTime,
            @RequestParam(required = false) String recurrence,
            RedirectAttributes redirectAttributes) {
        ReminderDTO reminderDTO = new ReminderDTO(id, name, reminderDateTime, recurrence);
        reminderService.updateReminder(id, reminderDTO);
        
        String message = "Reminder '" + name + "' updated successfully";
        redirectAttributes.addAttribute("notification", URLEncoder.encode(message, StandardCharsets.UTF_8));
        return "redirect:/reminders";
    }

    @GetMapping("/delete/{id}")
    public String deleteReminder(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        ReminderDTO reminder = reminderService.getReminderById(id);
        reminderService.deleteReminder(id);
        
        String message = "Reminder '" + reminder.getName() + "' deleted successfully";
        redirectAttributes.addAttribute("notification", URLEncoder.encode(message, StandardCharsets.UTF_8));
        return "redirect:/reminders";
    }

    @PostMapping("/{id}/trigger")
    public String triggerNotification(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        ReminderDTO reminder = reminderService.getReminderById(id);
        reminderService.triggerNotification(id);
        
        String message = "Reminder '" + reminder.getName() + "' triggered at " + 
                        new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm").format(reminder.getReminderDateTime());
        redirectAttributes.addAttribute("notification", URLEncoder.encode(message, StandardCharsets.UTF_8));
        return "redirect:/reminders";
    }
}
