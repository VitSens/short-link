package com.vitsen.short_url.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NotRightUrlException extends RuntimeException{
    public NotRightUrlException() {
        super("Url doesnt match", null, false, false);
    }

    public NotRightUrlException(String message) {
        super(message);
    }
}
