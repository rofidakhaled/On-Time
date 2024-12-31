package com.example.ontime.model.dto;

import java.util.Date;

public class ReminderDTO {
    private Long reminderID;
    private Date reminderDateTime;
    private String recurrence;

    // Constructor
    public ReminderDTO(Long reminderID, Date reminderDateTime, String recurrence) {
        this.reminderID = reminderID;
        this.reminderDateTime = reminderDateTime;
        this.recurrence = recurrence;
    }

    // Getters and Setters
    public Long getReminderID() {
        return reminderID;
    }

    public void setReminderID(Long reminderID) {
        this.reminderID = reminderID;
    }

    public Date getReminderDateTime() {
        return reminderDateTime;
    }

    public void setReminderDateTime(Date reminderDateTime) {
        this.reminderDateTime = reminderDateTime;
    }

    public String getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(String recurrence) {
        this.recurrence = recurrence;
    }
}
