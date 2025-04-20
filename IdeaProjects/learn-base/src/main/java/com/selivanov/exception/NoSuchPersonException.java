package com.selivanov.exception;

public class NoSuchPersonException extends RuntimeException {
    public NoSuchPersonException(String message) {
        super(message);
    }
}
