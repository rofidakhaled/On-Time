package com.example.ontime.model.dto;

public class UserDTO {

    private int id;
    private String name;
    private String email;
    private int password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPassword() {
        return password;
    }
    public void setPassword(int password) {
        this.password = password;
    }
    public int getId() {
        return id;
    }
}
