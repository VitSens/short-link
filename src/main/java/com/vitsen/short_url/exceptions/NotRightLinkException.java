package com.vitsen.short_url.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NotRightLinkException extends RuntimeException{

    public NotRightLinkException() {
        super("Link doesnt match");
    }
}
