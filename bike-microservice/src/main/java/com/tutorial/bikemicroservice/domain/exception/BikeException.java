package com.tutorial.bikemicroservice.domain.exception;

import org.springframework.http.HttpStatus;

public class BikeException extends RuntimeException {
    private final String title;
    private final HttpStatus status;

    public BikeException(String title, String message, HttpStatus status) {
        super(message);
        this.title = title;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
