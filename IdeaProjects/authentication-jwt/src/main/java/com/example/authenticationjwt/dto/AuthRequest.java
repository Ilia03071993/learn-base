package com.example.authenticationjwt.dto;

public record AuthRequest(
        String username,
        String password) {
}
