package com.nuevo.spa.gestortareas.exception;


import com.nuevo.spa.gestortareas.util.helper.TimestampHelper;
import com.nuevo.spa.gestortareas.util.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        return new ResponseEntity<>(new ErrorResponse(
                ex.getDetailMessageArguments()[1].toString(),
                TimestampHelper.getNowDate()),
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(NotFoundException ex) {
        return new ResponseEntity<>(new ErrorResponse(
                ex.getMessage(),
                TimestampHelper.getNowDate()),
                HttpStatus.NOT_FOUND);
    }

}
