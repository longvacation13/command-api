package com.main.test.controller;

import com.main.test.service.CommHttpService;
import com.main.test.service.impl.ExampleService;
import com.main.comm.dto.CommResDto;
import com.main.comm.dto.ResponseDto;
import com.main.exception.CustomException;
import com.main.discount.service.DiscountService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class TestController {

    private CommHttpService commHttpService;

    private DiscountService discountService;

    private ExampleService exampleService;

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

    @PostMapping(value = "/create-discount", produces="application/json")
    public ResponseDto<CommResDto> createDiscount(@RequestBody String discountKind) throws CustomException {

        discountService.createDiscount(discountKind);

        return new ResponseDto.Builder<CommResDto>()
                .status(HttpStatus.OK.value())
                .message(HttpStatus.OK.getReasonPhrase())
                .data(commHttpService.httpRequest())
                .build();
    }

    @GetMapping("/test-circuit-breaker")
    public String testCircuitBreaker(@RequestParam(defaultValue = "false") boolean triggerError) {
        return exampleService.unstableService(triggerError);
    }
}
