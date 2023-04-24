package com.ft.trox.controllers;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ft.trox.configs.security.AuthToken;
import com.ft.trox.configs.security.TokenUtil;
import com.ft.trox.dtos.LoginDto;
import com.ft.trox.services.LoginService;

@RestController
public class LoginController {
    
    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthToken> login(@RequestBody LoginDto dto) {
        try{
            var validateLogin = loginService.verifyLogin(dto);
            if (!validateLogin) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
            }

            return ResponseEntity.ok(TokenUtil.encodeToken(dto));
        } catch(NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }
}
