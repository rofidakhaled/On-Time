package com.example.ontime.controller;

import com.example.ontime.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    // Trigger a notification and send a response to the ui
    @PostMapping("/{id}/send")
    @ResponseBody
    public String triggerNotification(@PathVariable Long id) {
        notificationService.triggerNotification(id);
        return "Notification sent successfully";
    }
}
