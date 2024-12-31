package com.example.ontime.repository;

import com.example.ontime.entity.TaskManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TaskManagerRepository extends JpaRepository<TaskManager, String> {
    TaskManager findByUserId(String userId);
}