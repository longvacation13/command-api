package com.api.test.controller;


import com.comm.dto.ResponseDto;
import com.config.CustomException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class TestController {

    @GetMapping(value = "/testApi", produces="application/json")
    public ResponseEntity<ResponseDto> testApi(@RequestParam(required = false) String values) throws CustomException {
        ResponseDto successResponse = new ResponseDto("PROM_OK", "Success","Success Data");
        return ResponseEntity.ok(successResponse);
    }

}
