package com.nuevo.spa.gestortareas.exception;


import com.nuevo.spa.gestortareas.util.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        String fechaBuffer = LocalDateTime.now().toString();
        fechaBuffer = fechaBuffer.substring(0, fechaBuffer.indexOf("."));
        return new ResponseEntity<>(new ErrorResponse(
                ex.getDetailMessageArguments()[1].toString(),
                fechaBuffer),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(NotFoundException ex) {
        String fechaBuffer = LocalDateTime.now().toString();
        fechaBuffer = fechaBuffer.substring(0, fechaBuffer.indexOf("."));
        return new ResponseEntity<>(new ErrorResponse(
                ex.getMessage(),
                fechaBuffer),
                HttpStatus.NOT_FOUND);
    }

}
