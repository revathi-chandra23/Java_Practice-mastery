package com.example.feedback.exception;

import org.springframework.http.HttpStatusCode;
import java.util.List;

public class ApiError {

    private HttpStatusCode status;
    private String message;
    private String path;
    private List<FieldValidationError> errors;

    // ✅ Constructor 1 (no validation errors)
    public ApiError(HttpStatusCode status, String message, String path) {
        this.status = status;
        this.message = message;
        this.path = path;
    }

    // ✅ Constructor 2 (with validation errors)
    public ApiError(HttpStatusCode status, String message, String path, List<FieldValidationError> errors) {
        this.status = status;
        this.message = message;
        this.path = path;
        this.errors = errors;
    }

    // --- getters (IMPORTANT) ---
    public HttpStatusCode getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public List<FieldValidationError> getErrors() {
        return errors;
    }

    // --- Inner class ---
    public static class FieldValidationError {
        private String field;
        private String error;

        public FieldValidationError(String field, String error) {
            this.field = field;
            this.error = error;
        }

        public String getField() {
            return field;
        }

        public String getError() {
            return error;
        }
    }
}