package com.example.ontime.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.ontime.entity.ToDo;
import com.example.ontime.model.dto.ToDoDTO;
import com.example.ontime.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository todoRepository;

    public List<ToDo> getAllToDos() {
        return todoRepository.findAll();
    }

    public Optional<ToDo> getToDoById(int taskId) {
        return todoRepository.findById(String.valueOf(taskId));
    }
    public void addToDo(ToDoDTO todoDTO) {
        ToDo todo = new ToDo();
        todo.setTaskId(todoDTO.getTaskId());
        todo.setTaskName(todoDTO.getTaskName());
        todo.setTaskDescription(todoDTO.getTaskDescription());
        todo.setTaskStatus(todoDTO.getTaskStatus());
        todo.setTaskPriority(todoDTO.getTaskPriority());
        todo.setTaskDueDate(todoDTO.getTaskDueDate());
        todo.setTaskCompletedDate(todoDTO.getTaskCompletedDate());
        todo.setTaskCreatedDate(todoDTO.getTaskCreatedDate());
        todoRepository.save(todo);
    }

    public void updateToDo(int taskId, ToDoDTO todoDTO) {
        Optional<ToDo> todo = todoRepository.findById(String.valueOf(taskId));
        if (todo.isPresent()) {
            ToDo existingToDo = todo.get();
            existingToDo.setTaskId(todoDTO.getTaskId());
            existingToDo.setTaskName(todoDTO.getTaskName());
            existingToDo.setTaskDescription(todoDTO.getTaskDescription());
            existingToDo.setTaskStatus(todoDTO.getTaskStatus());
            existingToDo.setTaskPriority(todoDTO.getTaskPriority());
            existingToDo.setTaskDueDate(todoDTO.getTaskDueDate());
            existingToDo.setTaskCompletedDate(todoDTO.getTaskCompletedDate());
            existingToDo.setTaskCreatedDate(todoDTO.getTaskCreatedDate());
            todoRepository.save(existingToDo);
        }
    }
    public void deleteToDo(String taskId) {
        todoRepository.deleteById(taskId);
    }
}
