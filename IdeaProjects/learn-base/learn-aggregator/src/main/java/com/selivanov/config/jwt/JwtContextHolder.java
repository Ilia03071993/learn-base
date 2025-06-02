package com.selivanov.config.jwt;

import org.springframework.stereotype.Component;

@Component
//временно хранить токен в ThreadLocal
public class JwtContextHolder {
    private static final ThreadLocal<String> jwtHolder = new ThreadLocal<>();

    public static void setToken(String token) {
        jwtHolder.set(token);
    }

    public static String getToken() {
        return jwtHolder.get();
    }

    public static void clear() {
        jwtHolder.remove();
    }
}