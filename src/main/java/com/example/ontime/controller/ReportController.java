package com.example.ontime.controller;

import com.example.ontime.model.dto.ReportDTO;
import com.example.ontime.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping("/generate")
    @ResponseBody
    public ReportDTO generateReport(@RequestParam String timeFrame) {
        return reportService.generateReport(timeFrame);
    }

    // Get all reports
    @GetMapping
    @ResponseBody
    public List<ReportDTO> getAllReports() {
        return reportService.getAllReports();
    }
}

