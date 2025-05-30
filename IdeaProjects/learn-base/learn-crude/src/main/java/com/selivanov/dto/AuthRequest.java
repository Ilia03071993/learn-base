package com.selivanov.dto;

public record AuthRequest(
        String username,
        String password) {
}
