package com.example.ontime.entity;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reminderID; // Primary Key

    @Temporal(TemporalType.TIMESTAMP)
    private Date reminderDateTime;

    private String recurrence;

    @ElementCollection
    private List<Date> recurrenceTimeStamps;

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

    public List<Date> getRecurrenceTimeStamps() {
        return recurrenceTimeStamps;
    }

    public void setRecurrenceTimeStamps(List<Date> recurrenceTimeStamps) {
        this.recurrenceTimeStamps = recurrenceTimeStamps;
    }
}

