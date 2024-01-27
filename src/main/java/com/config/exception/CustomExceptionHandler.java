package com.config.exception;
import com.comm.dto.CommResDto;
import com.comm.dto.ResponseDto;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.logging.LogManager;
import java.util.logging.Logger;

// CustomExceptionHandler 클래스는
// @ControllerAdvice 어노테이션을 사용하여 모든 컨트롤러에서 발생하는 CustomException을 처리합니다.
@RestControllerAdvice(basePackages = {"com"})
@Order(Ordered.HIGHEST_PRECEDENCE) // 가장 높은 우선
@Slf4j
public class CustomExceptionHandler {


    // 예외 메시지와 HTTP 상태 코드를 클라이언트에게 반환합니다.
    @ExceptionHandler(CustomException.class)
    public ResponseDto<CommResDto> handleCustomException(CustomException ex) {

        // log
        log.error("#### handle custom Exception");

        CommResDto<String> commResDto
                = new CommResDto.Builder<String>().resultCode("500").resultData("exception").build();


        return new ResponseDto.Builder<CommResDto>()
                              .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                              .message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                              .data(commResDto)
                              .build()
                ;
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseDto<CommResDto> handleException(MethodArgumentNotValidException ex) {

        CommResDto<String> commResDto
                = new CommResDto.Builder<String>().resultCode("500").resultData("exception").build();

        log.error("#### handleException");
        return new ResponseDto.Builder<CommResDto>()
                              .status(HttpStatus.BAD_REQUEST.value())
                              .message(HttpStatus.BAD_REQUEST.getReasonPhrase())
                              .data(commResDto)
                              .build();
    }


}
