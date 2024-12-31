package com.example.ontime.controller;

import com.example.ontime.model.dto.ReminderDTO;
import com.example.ontime.entity.Reminder;
import com.example.ontime.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reminders")
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

    //  return ReminderDTO as JSON
    @PostMapping
    @ResponseBody
    public ReminderDTO addReminder(@RequestBody Reminder reminder) {
        return reminderService.addReminder(reminder);
    }

    @GetMapping
    @ResponseBody
    public List<ReminderDTO> getAllReminders() {
        return reminderService.getAllReminders();
    }

    // Trigger a notification
    @PostMapping("/{id}/trigger")
    @ResponseBody  // Ensure response is returned as JSON
    public void triggerNotification(@PathVariable Long id) {
        reminderService.triggerNotification(id);
    }

    // Schedule next recurrence
    @PostMapping("/{id}/schedule")
    @ResponseBody  // Ensure response is returned as JSON
    public void scheduleNext(@PathVariable Long id) {
        reminderService.scheduleNext(id);
    }
}



