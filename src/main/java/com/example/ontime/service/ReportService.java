package com.example.ontime.service;

import com.example.ontime.entity.Report;
import com.example.ontime.entity.ToDo;
import com.example.ontime.model.dto.ReportDTO;
import com.example.ontime.repository.ReportRepo;
import com.example.ontime.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportService {

    @Autowired
    private ReportRepo reportRepository;

    @Autowired
    private ToDoRepository todoRepository;

    public ReportDTO generateReport(String timeFrame) {

        List<ToDo> tasks = todoRepository.findAll();

        long totalTasks = tasks.size();
        long completedTasks = tasks.stream().filter(task -> "COMPLETED".equalsIgnoreCase(task.getTaskStatus())).count();
        long pendingTasks = totalTasks - completedTasks;


        String content = String.format(
                "Report for Time Frame: %s\nTotal Tasks: %d\nCompleted Tasks: %d\nPending Tasks: %d",
                timeFrame, totalTasks, completedTasks, pendingTasks
        );


        Report report = new Report(timeFrame, content);
        report = reportRepository.save(report);

        // Return as a DTO
        return new ReportDTO(report.getReportId(), report.getTimeFrame(), report.getContent(), report.getGeneratedDate());
    }

    public List<ReportDTO> getAllReports() {
        return reportRepository.findAll().stream()
                .map(report -> new ReportDTO(report.getReportId(), report.getTimeFrame(), report.getContent(), report.getGeneratedDate()))
                .collect(Collectors.toList());
    }
}

