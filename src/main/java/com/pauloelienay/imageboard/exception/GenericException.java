package com.pauloelienay.imageboard.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class GenericException extends RuntimeException {
    public GenericException(String message) {
        super(message);
    }
}
