package com.ft.trox.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ft.trox.dtos.LoginDto;
import com.ft.trox.models.User;
import com.ft.trox.repositories.UserRepository;

@Service
public class LoginService {
    private UserRepository userRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean verifyLogin(LoginDto dto) {
        Optional<User> possibleUser = this.userRepository.findByEmail(dto.email());
        if (possibleUser.isEmpty()) throw new NoSuchElementException();
        var user = possibleUser.get();
        return new BCryptPasswordEncoder().matches(dto.password(), user.getPassword());
    }
}
