package com.config.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
public class CustomException extends RuntimeException {

    private int status;

    public CustomException(int status, String message) {
        super(message);
        this.status = status;
    }

}
