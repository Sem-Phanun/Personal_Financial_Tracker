package com.project.personalfinancialmanagement.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResourceNotFoundException extends ApiException{
    private String resourceName;
    private Long resourceId;

    public ResourceNotFoundException(String resourceName, Long resourceId) {
        super(HttpStatus.NOT_FOUND, String.format("%s with id = %d not found", resourceName, resourceId));
    }
}
