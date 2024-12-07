package com.main.exception;
import com.main.comm.code.CommCodeEnum;
import com.main.comm.dto.CommResDto;
import com.main.comm.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

// CustomExceptionHandler 클래스는
// @ControllerAdvice 어노테이션을 사용하여 모든 컨트롤러에서 발생하는 CustomException을 처리합니다.
@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE) // 가장 높은 우선
@Slf4j
public class CustomExceptionHandler {


    // 예외 메시지와 HTTP 상태 코드를 클라이언트에게 반환합니다.
    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseDto<CommResDto> handleCustomException(CustomException ex) {

        // log
        log.error("#### handleCustomException : ");
        for(StackTraceElement stackTraceElement : ex.getStackTrace()) {
            log.error(stackTraceElement.toString());
        }

        CommResDto<String> commResDto
                = new CommResDto.Builder<String>()
                                .resultCode(CommCodeEnum.ApiResponse_901.getCode())         // service method exception을 여기서 처리함
                                .resultData(CommCodeEnum.ApiResponse_901.getCodeMsg()).build();


        return new ResponseDto.Builder<CommResDto>()
                              .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                              .message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                              .data(commResDto)
                              .build();
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDto<CommResDto> handleException(MethodArgumentNotValidException ex) {

        CommResDto<String> commResDto
                = new CommResDto.Builder<String>()
                                .resultCode(CommCodeEnum.ApiResponse_999.getCode())
                                .resultData(CommCodeEnum.ApiResponse_999.getCodeMsg()).build();

        log.error("#### handleException");
        return new ResponseDto.Builder<CommResDto>()
                              .status(HttpStatus.BAD_REQUEST.value())
                              .message(HttpStatus.BAD_REQUEST.getReasonPhrase())
                              .data(commResDto)
                              .build();
    }


}
