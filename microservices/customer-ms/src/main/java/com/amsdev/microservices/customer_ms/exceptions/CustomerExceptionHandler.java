package com.amsdev.microservices.customer_ms.exceptions;

import com.amsdev.microservices.common_exceptions.ErrorResponse;
import com.amsdev.microservices.common_exceptions.GlobalExceptionHandler;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice(basePackages = "com.amsdev.microservices.customer_ms")
@Primary
public class CustomerExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorResponse> handle(CustomerNotFoundException exception){
        var errors = new HashMap<String,String>();
        var fieldName = "customers";
        errors.put(fieldName,exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors));
    }
}
