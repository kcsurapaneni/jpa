package com.learn.jpa.service;

import com.learn.jpa.dto.*;
import com.learn.jpa.exception.*;
import com.learn.jpa.model.*;
import com.learn.jpa.repository.*;
import org.springframework.stereotype.*;

/**
 * @author Krishna Chaitanya
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserDTO addUser(UserDTO inputUser) {
        User savedUser = userRepository.save(User.fromUserDTO(inputUser));
        return User.toUserDTO(savedUser);
    }

    public UserDTO getUser(final Integer id) {
        return userRepository.findById(id).map(User::toUserDTO).orElseThrow(() -> new UserNotFoundException(id));
    }

}
