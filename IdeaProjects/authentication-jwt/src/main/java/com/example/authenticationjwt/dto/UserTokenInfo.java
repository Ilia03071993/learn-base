package com.example.authenticationjwt.dto;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public record UserTokenInfo(String Username,
                            Collection<? extends GrantedAuthority> authorities) {

}
