package com.example.ontime.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Reminder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reminderID;

    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    private Date reminderDateTime;

    private String recurrence;

    @ElementCollection
    private List<Date> recurrenceTimeStamps = new ArrayList<>();

    // Default constructor
    public Reminder() {
    }

    // Getters and Setters
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

    public List<Date> getRecurrenceTimeStamps() {
        return recurrenceTimeStamps;
    }

    public void setRecurrenceTimeStamps(List<Date> recurrenceTimeStamps) {
        this.recurrenceTimeStamps = recurrenceTimeStamps;
    }
}
