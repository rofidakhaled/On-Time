package com.example.ontime.model.dto;

import java.util.List;

public class ReportDTO {
    private List<ToDoDTO> todos;
    private List<ReminderDTO> reminders;

    public ReportDTO(List<ToDoDTO> todos, List<ReminderDTO> reminders) {
        this.todos = todos;
        this.reminders = reminders;
    }

    public List<ToDoDTO> getTodos() {
        return todos;
    }

    public void setTodos(List<ToDoDTO> todos) {
        this.todos = todos;
    }

    public List<ReminderDTO> getReminders() {
        return reminders;
    }

    public void setReminders(List<ReminderDTO> reminders) {
        this.reminders = reminders;
    }
}
