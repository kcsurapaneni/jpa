package com.learn.jpa.controller;

import com.learn.jpa.dto.*;
import com.learn.jpa.exception.*;
import com.learn.jpa.service.*;
import jakarta.validation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

/**
 * @author Krishna Chaitanya
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    ResponseEntity<UserDTO> addUser(@Valid @RequestBody UserDTO user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.addUser(user));
    }

    @GetMapping("/{id}")
    ResponseEntity<UserDTO> addUser(@PathVariable("id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(id));
    }

}
