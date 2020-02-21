package com.example.Sales.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class OrderCannotBeCreated extends RuntimeException {

    public OrderCannotBeCreated(String message) {
        super(message);
    }

    public OrderCannotBeCreated(String message, Throwable cause) {
        super(message, cause);
    }

}
