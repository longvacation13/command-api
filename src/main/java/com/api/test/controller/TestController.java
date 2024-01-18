package com.api.test.controller;


import com.comm.dto.ResponseDto;
import com.config.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestController {

    @GetMapping("/testApi")
    public ResponseEntity<ResponseDto> testApi() {
        int a = 1;
        if (a == 1) {
            ResponseDto errorResponse = new ResponseDto("PROM_999", "ERROR", "ERROR DATA");
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorResponse);
        }

        ResponseDto successResponse = new ResponseDto("PROM_OK", "Success","Success Data");
        return ResponseEntity.ok(successResponse);

    }

}
