package com.example.authenticationjwt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchRoleException extends RuntimeException{

    public NoSuchRoleException(String message) {
        super(message);
    }
}
