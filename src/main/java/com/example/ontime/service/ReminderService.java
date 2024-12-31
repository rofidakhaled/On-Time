package com.example.ontime.service;

import com.example.ontime.entity.Reminder;
import com.example.ontime.model.dto.ReminderDTO;
import com.example.ontime.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;

    public ReminderDTO addReminder(Reminder reminder) {
        Reminder savedReminder = reminderRepository.save(reminder);
        return convertToDTO(savedReminder);
    }

    public List<ReminderDTO> getAllReminders() {
        List<Reminder> reminders = reminderRepository.findAll();
        return reminders.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ReminderDTO getReminderById(Long id) {
        Optional<Reminder> reminder = reminderRepository.findById(id);
        return reminder.map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("Reminder not found"));
    }

    public void updateReminder(Long id, ReminderDTO reminderDTO) {
        Reminder reminder = reminderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reminder not found"));
        
        reminder.setName(reminderDTO.getName());
        reminder.setReminderDateTime(reminderDTO.getReminderDateTime());
        reminder.setRecurrence(reminderDTO.getRecurrence());
        
        reminderRepository.save(reminder);
    }

    public void deleteReminder(Long id) {
        reminderRepository.deleteById(id);
    }

    public void triggerNotification(Long id) {
        Reminder reminder = reminderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reminder not found"));
        // Here you would implement the actual notification logic
        System.out.println("Notification triggered for reminder: " + reminder.getName() + 
                          " at " + reminder.getReminderDateTime());
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

    private ReminderDTO convertToDTO(Reminder reminder) {
        return new ReminderDTO(
            reminder.getReminderID(),
            reminder.getName(),
            reminder.getReminderDateTime(),
            reminder.getRecurrence()
        );
    }
}
