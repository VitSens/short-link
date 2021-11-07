package com.vitsen.short_url.exceptions.controller_advices;

import com.vitsen.short_url.exceptions.NotRightUrlException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@EnableWebMvc
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotRightUrlException.class)
    @ResponseBody
    public ResponseEntity<ErrorMessage> handleUrlNotRightException(NotRightUrlException ex) {
        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setStatus(HttpStatus.BAD_REQUEST.value());
        errorMessage.setMessage(ex.getMessage());
        errorMessage.setTimestamp(LocalDateTime.now());

        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }
}
