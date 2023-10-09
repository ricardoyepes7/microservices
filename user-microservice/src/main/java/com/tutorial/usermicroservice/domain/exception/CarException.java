package com.tutorial.usermicroservice.domain.exception;

public class CarException extends RuntimeException{
    public CarException() {
    }

    public CarException(String message) {
        super(message);
    }
}
