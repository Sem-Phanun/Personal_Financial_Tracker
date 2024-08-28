package com.project.personalfinancialmanagement.exception;

import lombok.*;
import org.springframework.http.HttpStatus;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
public class ApiException extends RuntimeException {
    private final HttpStatus status;
    private final String message;
}
