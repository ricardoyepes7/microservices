package com.tutorial.usermicroservice.infrastructure.advice;

import com.tutorial.usermicroservice.domain.exception.UserException;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(UserException.class)
    public ResponseEntity<ProblemDetail> userException(UserException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(ex.getStatus(),
                ex.getMessage());
        problemDetail.setTitle(ex.getTitle());
        return ResponseEntity.status(ex.getStatus()).body(problemDetail);
    }
}
