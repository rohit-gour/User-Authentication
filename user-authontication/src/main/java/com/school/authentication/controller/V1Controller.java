package com.school.authentication.controller;

import com.school.authentication.dto.UserLoginDTO;
import com.school.authentication.dto.UserRegistrationDetailDTO;
import com.school.authentication.dto.UserResponseDTO;
import com.school.authentication.service.UserLogin;
import com.school.authentication.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
public class V1Controller {
private static final Logger l = LoggerFactory.getLogger(V1Controller.class);
    @Autowired
    private UserService userService;
    @Autowired
    private UserLogin userLogin;


    @PostMapping("/userRegistration")
    public ResponseEntity<Object> createUser(
           @Valid @RequestBody UserRegistrationDetailDTO userRegistrationDetailDTO
    ) {
        l.debug("Something went wrong!!");
        if(userService.createUser(userRegistrationDetailDTO)) {
            return new ResponseEntity<>("User registration is success!", HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>("Unable to do user registration! Might be the user already Exist :)", HttpStatus.BAD_REQUEST);
        }
    }

//    @ResponseBody
    @GetMapping("/getUser")
    public UserResponseDTO getUser(@RequestBody UserLoginDTO userLoginDTO){
        return userLogin.getLogin(userLoginDTO);
    }
}
