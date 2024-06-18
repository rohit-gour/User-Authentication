package com.school.authentication.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


public class UserLoginDTO {
    @NotBlank
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @NotBlank
        private String password;
}
