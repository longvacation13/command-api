package com.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// CustomExceptionHandler 클래스는
// @ControllerAdvice 어노테이션을 사용하여 모든 컨트롤러에서 발생하는 CustomException을 처리합니다.
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    // 예외 메시지와 HTTP 상태 코드를 클라이언트에게 반환합니다.
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleCustomException(CustomException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), ex.getStatus(), request);
    }

}
