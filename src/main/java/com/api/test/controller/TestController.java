package com.api.test.controller;

import com.api.test.service.CommHttpService;
import com.comm.dto.CommResDto;
import com.comm.dto.ResponseDto;
import com.config.exception.CustomException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class TestController {

    private CommHttpService commHttpService;

    @GetMapping(value = "/testApi", produces="application/json")
    public ResponseDto<CommResDto> testApi(@RequestParam(required = false) @Valid String values) throws Exception {
        return new ResponseDto.Builder<CommResDto>()
                              .status(HttpStatus.OK.value())
                              .message(HttpStatus.OK.getReasonPhrase())
                              .build();
    }


    @GetMapping(value = "/http2Test", produces="application/json")
    public ResponseDto<CommResDto> http2Test() throws CustomException {
        return new ResponseDto.Builder<CommResDto>()
                .status(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(commHttpService.httpRequest())
                .build();
    }


}
