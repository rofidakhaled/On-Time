package com.example.ontime.model.dto;

import java.util.Date;

public class ReportDTO {

    private Long reportId;
    private String timeFrame;
    private String content;
    private Date generatedDate;

    public ReportDTO(Long reportId, String timeFrame, String content, Date generatedDate) {
        this.reportId = reportId;
        this.timeFrame = timeFrame;
        this.content = content;
        this.generatedDate = generatedDate;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public String getTimeFrame() {
        return timeFrame;
    }

    public void setTimeFrame(String timeFrame) {
        this.timeFrame = timeFrame;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getGeneratedDate() {
        return generatedDate;
    }

    public void setGeneratedDate(Date generatedDate) {
        this.generatedDate = generatedDate;
    }
}

