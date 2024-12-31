package com.example.ontime.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Notification {

    @Id
    private Long id;
    private Date sentDateTime;

    public Notification() {}

    public Notification(Date sentDateTime) {
        this.sentDateTime = sentDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getSentDateTime() {
        return sentDateTime;
    }

    public void setSentDateTime(Date sentDateTime) {
        this.sentDateTime = sentDateTime;
    }
}

