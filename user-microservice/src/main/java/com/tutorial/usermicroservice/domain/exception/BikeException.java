package com.tutorial.usermicroservice.domain.exception;

public class BikeException extends RuntimeException{
    public BikeException() {
    }

    public BikeException(String message) {
        super(message);
    }
}
