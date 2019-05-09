package com.norestfortheapi.webshop.userservice.controller;

import com.norestfortheapi.webshop.userservice.model.ShitwishUser;
import com.norestfortheapi.webshop.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ShitwishUser getUserById(@PathVariable("id") Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/authentication")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void authenticateUser(@RequestBody ShitwishUser user){
        if (!userService.authenticateUser(user)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username os password is not correct!");
        }
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(
        @RequestBody ShitwishUser newUser
        ) {
        String encodedPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(encodedPassword);
        userService.registerUser(newUser);
    }

}
