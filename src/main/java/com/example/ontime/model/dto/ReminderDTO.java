package com.example.ontime.model.dto;

import java.util.Date;

public class ReminderDTO {
    private Long reminderID;
    private String name;
    private Date reminderDateTime;
    private String recurrence;

    public ReminderDTO() {
    }

    public ReminderDTO(Long reminderID, String name, Date reminderDateTime, String recurrence) {
        this.reminderID = reminderID;
        this.name = name;
        this.reminderDateTime = reminderDateTime;
        this.recurrence = recurrence;
    }

    public Long getReminderID() {
        return reminderID;
    }

    public void setReminderID(Long reminderID) {
        this.reminderID = reminderID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
