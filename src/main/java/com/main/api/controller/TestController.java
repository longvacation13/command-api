package com.main.api.controller;

import com.main.api.service.CommHttpService;
import com.main.comm.dto.CommResDto;
import com.main.comm.dto.ResponseDto;
import com.main.exception.CustomException;
import com.main.discount.DiscountService;
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
}
