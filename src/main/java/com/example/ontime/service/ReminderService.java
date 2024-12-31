package com.example.ontime.service;


import com.example.ontime.entity.Reminder;
import com.example.ontime.repository.ReminderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import com.example.ontime.model.dto.ReminderDTO;

import java.util.stream.Collectors;

@Service
public class ReminderService {

    @Autowired
    private ReminderRepo reminderRepository;

    // Add a new reminder and return the DTO
    public ReminderDTO addReminder(Reminder reminder) {
        Reminder savedReminder = reminderRepository.save(reminder);
        // Convert entity to DTO and return
        return new ReminderDTO(
                savedReminder.getReminderID(),
                savedReminder.getReminderDateTime(),
                savedReminder.getRecurrence()
        );
    }


    public List<ReminderDTO> getAllReminders() {
        List<Reminder> reminders = reminderRepository.findAll();
        // Convert all entities to DTOs
        return reminders.stream()
                .map(reminder -> new ReminderDTO(
                        reminder.getReminderID(),
                        reminder.getReminderDateTime(),
                        reminder.getRecurrence()
                ))
                .collect(Collectors.toList());
    }


    public void triggerNotification(Long reminderID) {
        Reminder reminder = reminderRepository.findById(reminderID).orElseThrow(() ->
                new RuntimeException("Reminder not found"));


        System.out.println("Triggering notification for reminder: " + reminder.getReminderID());
    }


    public void scheduleNext(Long reminderID) {
        Reminder reminder = reminderRepository.findById(reminderID).orElseThrow(() ->
                new RuntimeException("Reminder not found"));

        if (reminder.getRecurrence() != null && !reminder.getRecurrence().equalsIgnoreCase("none")) {

            Date nextDate = new Date(reminder.getReminderDateTime().getTime() + 86400000); // 1 day ms
            reminder.getRecurrenceTimeStamps().add(nextDate);
            reminder.setReminderDateTime(nextDate);
            reminderRepository.save(reminder);
        }
    }
}

