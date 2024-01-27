package com.comm.code;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum CommCodeEnum {

    ApiResponse_200("CMD_200", "OK"),
    ApiResponse_901("CMD_901", "ApiException"),
    ApiResponse_900("CMD_900","ApiResponseError");

    private final String code;
    private final String codeMsg;

    private CommCodeEnum(String code, String codeMsg) {
        this.code = code;
        this.codeMsg = codeMsg;
    }

}
