package com.ft.trox.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import com.ft.trox.dtos.UserDto;
import com.ft.trox.models.enums.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.JdbcType;
import org.hibernate.type.descriptor.jdbc.VarcharJdbcType;

@Entity
public class User implements Serializable{
    private static final Long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JdbcType(VarcharJdbcType.class)
    private UUID id;

    @Column(nullable = false, length = 20, unique = false)
    private String username;

    @Column(nullable = false, length = 500)
    private String password;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(nullable = false)
    private boolean active;

    private LocalDateTime createdAt;

    public User(String username, String password, String email, UserRole role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.active = true;
        this.createdAt = LocalDateTime.now();
    }

    public User(UserDto dto) {
        this(dto.username(), dto.password(), dto.email(), UserRole.valueOf(dto.role()));
    }

    @Deprecated
    public User() {
    }

    public static Long getSerialversionuid() {
        return SerialVersionUID;
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public UserRole getRole() {
        return role;
    }

    public boolean isActive() {
        return active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void encodePassword(String password) {
        this.password = password;
    }
}
