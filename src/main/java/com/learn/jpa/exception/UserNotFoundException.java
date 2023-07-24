package com.learn.jpa.exception;

import org.springframework.http.*;
import org.springframework.web.*;

/**
 * @author Krishna Chaitanya
 */
public class UserNotFoundException extends ErrorResponseException {

    public UserNotFoundException(Integer id) {
        super(HttpStatus.NOT_FOUND, asProblemDetail("User with id " + id + " not found"), null);
    }

    private static ProblemDetail asProblemDetail(final String message) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, message);
        problemDetail.setTitle("User not found");
        return problemDetail;
    }

}
