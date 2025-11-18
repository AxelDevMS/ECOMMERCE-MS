package com.amsdev.microservices.customer_ms.exceptions;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
public class CustomerNotFoundException extends RuntimeException {

    private String message;

    public CustomerNotFoundException(String format) {
        this.message = format;
    }


    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
