package com.example.feedback.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.data.mongodb.UncategorizedMongoDbException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // --- Custom domain errors ---
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(ResourceNotFoundException ex, WebRequest request) {
        ApiError apiError = new ApiError(
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                request.getDescription(false)
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequest(BadRequestException ex, WebRequest request) {
        ApiError apiError = new ApiError(
                HttpStatus.BAD_REQUEST,
                ex.getMessage(),
                request.getDescription(false)
        );
        return ResponseEntity.badRequest().body(apiError);
    }

    // --- Validation: @Valid on request bodies ---
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex, WebRequest request) {
        List<ApiError.FieldValidationError> fieldErrors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fe -> new ApiError.FieldValidationError(fe.getField(), resolveFieldErrorMessage(fe)))
                .toList();

        ApiError apiError = new ApiError(
                HttpStatus.BAD_REQUEST,
                "Validation failed for request body",
                request.getDescription(false),
                fieldErrors
        );
        return ResponseEntity.badRequest().body(apiError);
    }

    private String resolveFieldErrorMessage(FieldError fe) {
        // Prefer default message; fallback to code
        return fe.getDefaultMessage() != null ? fe.getDefaultMessage() : (fe.getCode() + " error");
    }

    // --- Validation: @Validated on params/path variables ---
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiError> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
        List<ApiError.FieldValidationError> fieldErrors = ex.getConstraintViolations()
                .stream()
                .map(cv -> new ApiError.FieldValidationError(cv.getPropertyPath().toString(), cv.getMessage()))
                .toList();

        ApiError apiError = new ApiError(
                HttpStatus.BAD_REQUEST,
                "Validation failed for request parameters",
                request.getDescription(false),
                fieldErrors
        );
        return ResponseEntity.badRequest().body(apiError);
    }

    // --- Type mismatch (e.g., rating text where int expected) ---
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ApiError> handleTypeMismatch(MethodArgumentTypeMismatchException ex, WebRequest request) {
        String msg = String.format("Parameter '%s' must be of type %s",
                ex.getName(),
                ex.getRequiredType() != null ? ex.getRequiredType().getSimpleName() : "expected type");
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, msg, request.getDescription(false));
        return ResponseEntity.badRequest().body(apiError);
    }

    // --- Missing required request param ---
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ApiError> handleMissingParam(MissingServletRequestParameterException ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, ex.getMessage(), request.getDescription(false));
        return ResponseEntity.badRequest().body(apiError);
    }

    // --- Malformed JSON body ---
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ApiError> handleNotReadable(HttpMessageNotReadableException ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, "Malformed JSON request", request.getDescription(false));
        return ResponseEntity.badRequest().body(apiError);
    }

    // --- Mongo & data layer common issues (narrow these as needed) ---
    @ExceptionHandler({ DuplicateKeyException.class })
    public ResponseEntity<ApiError> handleDuplicateKey(DuplicateKeyException ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.CONFLICT, "Duplicate key error", request.getDescription(false));
        return ResponseEntity.status(HttpStatus.CONFLICT).body(apiError);
    }

    @ExceptionHandler(UncategorizedMongoDbException.class)
    public ResponseEntity<ApiError> handleMongo(UncategorizedMongoDbException ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.SERVICE_UNAVAILABLE, "Database error", request.getDescription(false));
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(apiError);
    }

    // --- Spring's generic ErrorResponseException (if used anywhere) ---
    @ExceptionHandler(ErrorResponseException.class)
    public ResponseEntity<ApiError> handleErrorResponse(ErrorResponseException ex, WebRequest request) {
        ApiError apiError = new ApiError(ex.getStatusCode(), ex.getBody().getDetail(), request.getDescription(false));
        return ResponseEntity.status(ex.getStatusCode()).body(apiError);
    }

    // --- Fallback (kept last) ---
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleAll(Exception ex, WebRequest request) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, "Unexpected error", request.getDescription(false));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
    }
}
``