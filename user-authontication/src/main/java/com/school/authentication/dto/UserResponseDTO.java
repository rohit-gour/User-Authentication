package com.school.authentication.dto;

import lombok.Data;


public class UserResponseDTO {
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private String userName;
    private String role;
}
