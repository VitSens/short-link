package com.vitsen.short_url.exceptions.controller_advices;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private LocalDateTime timestamp;
    private Integer status;
    private String message;
}
