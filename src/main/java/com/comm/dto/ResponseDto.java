package com.comm.dto;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResponseDto {
    private String resultCode;
    private String resultMessage;
    private Object data;

}
