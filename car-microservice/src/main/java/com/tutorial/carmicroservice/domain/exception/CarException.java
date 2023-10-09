package com.tutorial.carmicroservice.domain.exception;

import org.springframework.http.HttpStatus;

public class CarException extends RuntimeException{
    private final String title;
    private final HttpStatus status;

    public CarException( String title,String message, HttpStatus status) {
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
