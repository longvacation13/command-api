package com.comm.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ResponseDto {
    private String resultCode;
    private String resultMessage;
    private Object data;
}
