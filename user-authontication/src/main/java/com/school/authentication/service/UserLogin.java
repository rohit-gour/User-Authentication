package com.school.authentication.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.authentication.dto.UserLoginDTO;
import com.school.authentication.dto.UserRegistrationDetailDTO;
import com.school.authentication.dto.UserResponseDTO;
import com.school.authentication.exception.UserNotFoundException;
import com.school.authentication.repository.userRepository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserLogin {

    private static final Logger logger = LoggerFactory.getLogger(UserLogin.class);
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO getLogin(UserLoginDTO userLoginDTO){

        UserResponseDTO userResponseDTO = null;
        Optional<UserRegistrationDetailDTO> userDetails = userRepository.findByUserName(userLoginDTO.getUserName());

        if(!userDetails.isEmpty()) {
            userResponseDTO = objectMapper.convertValue(userDetails, UserResponseDTO.class);
            logger.info("User data by userName: {}", userDetails);
        }
        else {
            throw new UserNotFoundException("Sorry no user found!");
        }
        return userResponseDTO;
    }
}
