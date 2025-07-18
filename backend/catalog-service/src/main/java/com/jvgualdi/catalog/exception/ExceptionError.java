package com.jvgualdi.catalog.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionError {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private List<String> details;
}
