package com.example.ontime.service;


import com.example.ontime.entity.Notification;
import com.example.ontime.repository.NotificationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepo notificationRepository;


    public void triggerNotification(Long id) {
        Notification notification = notificationRepository.findById(id).orElseThrow(() -> new RuntimeException("Notification not found"));
        notification.setSentDateTime(new Date());
        notificationRepository.save(notification);
    }
}
