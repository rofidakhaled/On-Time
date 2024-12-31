package com.example.ontime.repository;
import com.example.ontime.entity.Reminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReminderRepo extends JpaRepository<Reminder, Long> {
}

