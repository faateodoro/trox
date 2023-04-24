package com.ft.trox.configs.security;

public class AuthToken {
    private String token;

    public String getToken() {
        return token;
    }

    public AuthToken(String token) {
        this.token = token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public AuthToken() {
    }

}
