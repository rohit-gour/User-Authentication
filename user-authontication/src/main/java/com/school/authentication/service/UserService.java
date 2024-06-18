package com.school.authentication.service;

import com.school.authentication.dto.UserRegistrationDetailDTO;
import com.school.authentication.exception.DuplicateUsernameException;
import com.school.authentication.repository.userRepository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);


    //Method with try and catch block. Here try and catch block is not that importnat we can use
    // if condition to handle if the username is already taken.

    public boolean createUser(UserRegistrationDetailDTO userRegistrationDetailDTO) {
        try {

            if (userRepository.existsByUserName(userRegistrationDetailDTO.getUserName())) {
                logger.debug("User is already exists", userRegistrationDetailDTO.getUserName());
                throw new DuplicateUsernameException("Username already exists: " + userRegistrationDetailDTO.getUserName());
            }

            userRepository.save(userRegistrationDetailDTO);
            return true;
        } catch (DuplicateUsernameException e) {
            logger.error("Error occured during user registration! ", e);
            return false;
        }
    }
}
