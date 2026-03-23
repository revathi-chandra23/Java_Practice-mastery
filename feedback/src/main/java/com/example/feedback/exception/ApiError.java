package com.example.feedback.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.List;

public class ApiError {
    private HttpStatus status;
    private String message;
    private String path;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime timestamp;

    // Optional: list of field errors for validation issues
    private List<FieldValidationError> errors;

    public ApiError(HttpStatus status, String message, String path) {
        this.status = status;
        this.message = message;
        this.path = path;
        this.timestamp = LocalDateTime.now();
    }

    public ApiError(HttpStatus status, String message, String path, List<FieldValidationError> errors) {
        this(status, message, path);
        this.errors = errors;
    }

    // getters/setters...

    public static class FieldValidationError {
        private String field;
        private String error;

        public FieldValidationError(String field, String error) {
            this.field = field;
            this.error = error;
        }
        // getters/setters...
    }
}