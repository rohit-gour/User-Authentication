package com.school.authentication.repository.userRepository;

import com.school.authentication.dto.UserRegistrationDetailDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<UserRegistrationDetailDTO, String> {

        /*
         * existsByUserName is used to validate wether the user is already registred or not. It will return true if the userName already exits
         */
        boolean existsByUserName(String userName);
        /*
        * findByUserName is used to find the details of a user by "userName"
        */
        Optional<UserRegistrationDetailDTO> findByUserName(String userName);
}
