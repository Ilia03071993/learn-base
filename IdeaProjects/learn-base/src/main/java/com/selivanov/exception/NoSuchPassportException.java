package com.selivanov.exception;

public class NoSuchPassportException extends RuntimeException {
    public NoSuchPassportException(String message) {
        super(message);
    }
}