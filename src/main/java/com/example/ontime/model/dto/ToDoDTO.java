package com.example.ontime.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class ToDoDTO {
    private int taskId;
    private String taskName;
    private String taskDescription;
    private String taskStatus;
    private int taskPriority;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date taskDueDate;
    private Date taskCompletedDate;
    private Date taskCreatedDate;

    public int getTaskId() {
        return taskId;
    }
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
    public String getTaskDescription() {
        return taskDescription;
    }
    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
    public String getTaskStatus() {
        return taskStatus;
    }
    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }
    public int getTaskPriority() {
        return taskPriority;
    }
    public void setTaskPriority(int taskPriority) {
        this.taskPriority = taskPriority;
    }
    public Date getTaskDueDate() {
        return taskDueDate;
    }
    public void setTaskDueDate(Date taskDueDate) {
        this.taskDueDate = taskDueDate;
    }
    public Date getTaskCompletedDate() {
        return taskCompletedDate;
    }
    public void setTaskCompletedDate(Date taskCompletedDate) {
        this.taskCompletedDate = taskCompletedDate;
    }
    public Date getTaskCreatedDate() {
        return taskCreatedDate;
    }
    public void setTaskCreatedDate(Date taskCreatedDate) {
        this.taskCreatedDate = taskCreatedDate;
    }
}
