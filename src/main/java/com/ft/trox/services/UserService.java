package com.ft.trox.services;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ft.trox.dtos.UserDto;
import com.ft.trox.models.User;
import com.ft.trox.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public User createUser (UserDto dto) {
        User user = new User(dto);
        user.encodePassword(new BCryptPasswordEncoder().encode(dto.password()));
        userRepository.save(user);
        return user;
    }
}
