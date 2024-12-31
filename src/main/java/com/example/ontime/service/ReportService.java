package com.example.ontime.service;

import com.example.ontime.model.dto.ReportDTO;
import com.example.ontime.model.dto.ToDoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Comparator;
import com.example.ontime.entity.ToDo;

@Service
public class ReportService {

    @Autowired
    private ToDoService toDoService;

    @Autowired
    private ReminderService reminderService;

    public ReportDTO generateReport() {
        List<ToDoDTO> todos = toDoService.getAllToDos().stream()
            .map(this::convertToDTO)
            .sorted(Comparator
                .comparing((ToDoDTO t) -> "COMPLETED".equals(t.getTaskStatus())) // Completed items last
                .thenComparing(t -> "HIGH".equals(t.getTaskPriority()) ? 0 :     // Then by priority
                              "MEDIUM".equals(t.getTaskPriority()) ? 1 : 2)
                .thenComparing(ToDoDTO::getTaskDueDate))                         // Then by due date
            .collect(Collectors.toList());

        return new ReportDTO(todos, reminderService.getAllReminders());
    }

    private ToDoDTO convertToDTO(ToDo todo) {
        ToDoDTO dto = new ToDoDTO();
        dto.setTaskId(todo.getTaskId());
        dto.setTaskName(todo.getTaskName());
        dto.setTaskDescription(todo.getTaskDescription());
        dto.setTaskStatus(todo.getTaskStatus());
        dto.setTaskPriority(todo.getTaskPriority());
        dto.setTaskDueDate(todo.getTaskDueDate());
        dto.setTaskCompletedDate(todo.getTaskCompletedDate());
        dto.setTaskCreatedDate(todo.getTaskCreatedDate());
        return dto;
    }
}
