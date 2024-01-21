package com.config.exception;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// CustomExceptionHandler 클래스는
// @ControllerAdvice 어노테이션을 사용하여 모든 컨트롤러에서 발생하는 CustomException을 처리합니다.
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    // 예외 메시지와 HTTP 상태 코드를 클라이언트에게 반환합니다.
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleCustomException(CustomException ex) {
        ErrorResponse errorResponse = new ErrorResponse(ex.getStatus(), ex.getMessage());
        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }

    // ErrorResponse는 클라이언트에게 반환할 에러 정보를 담는 클래스입니다.
    // 여기서는 상태 코드와 메시지를 포함합니다.

    @Getter
    private static class ErrorResponse {
        private HttpStatus status;
        private String message;

        public ErrorResponse(HttpStatus status, String message) {
            this.status = status;
            this.message = message;
        }
    }
}
