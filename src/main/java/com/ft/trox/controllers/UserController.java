package com.ft.trox.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ft.trox.dtos.UserDto;
import com.ft.trox.models.User;
import com.ft.trox.services.UserService;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/usuarios")
    public ResponseEntity<User> create(@RequestBody UserDto dto) {
        User user = userService.createUser(dto);
        return ResponseEntity.ok(user);
    }
}
