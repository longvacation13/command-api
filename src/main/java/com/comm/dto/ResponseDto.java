package com.comm.dto;


import lombok.*;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;


@Getter
public class ResponseDto {
    private final HttpStatus status;
    private final String message;
    private final Object data;

    private ResponseDto(Builder builder) {
        this.status  = builder.status;
        this.message = builder.message;
        this.data    = builder.data;
    }

    public static class Builder {
        private HttpStatus status;
        private String message;
        private Object data;

        public Builder status(HttpStatus status) {
            this.status = status;
            return this;
        }
        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder data(Object data) {
            this.data = data;
            return this;
        }

        public ResponseDto build() {
            return new ResponseDto(this);
        }
    }

}
