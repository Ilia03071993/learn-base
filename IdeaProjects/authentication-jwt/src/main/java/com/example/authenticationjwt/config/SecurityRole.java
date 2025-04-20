package com.example.authenticationjwt.config;

import com.example.authenticationjwt.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@RequiredArgsConstructor
public class SecurityRole implements GrantedAuthority {
    private final Role role;

    @Override
    public String getAuthority() {
        return "ROLE_" + role.getName();
    }
}
