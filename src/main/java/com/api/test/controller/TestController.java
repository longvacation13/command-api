package com.api.test.controller;

import com.api.test.service.MergeSortService;
import com.comm.dto.CommResDto;
import com.comm.dto.ResponseDto;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class TestController {

    private MergeSortService mergeSortService;

    // 클래스의 첫번째 생성자는 자동으로 autowired된다.
    public TestController(MergeSortService mergeSortService) {
        this.mergeSortService = mergeSortService;
    }


    @GetMapping(value = "/testApi", produces="application/json")
    public ResponseDto<CommResDto> testApi(@RequestParam(required = false) @Valid String values) throws Exception {
        return new ResponseDto.Builder<CommResDto>()
                              .status(HttpStatus.OK.value())
                              .message("OK")
                              .build();
    }

}
