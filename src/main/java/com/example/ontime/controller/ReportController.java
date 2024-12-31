package com.example.ontime.controller;

import com.example.ontime.model.dto.ReportDTO;
import com.example.ontime.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    public String showReport(Model model) {
        ReportDTO report = reportService.generateReport();
        model.addAttribute("report", report);
        return "report";
    }
}
