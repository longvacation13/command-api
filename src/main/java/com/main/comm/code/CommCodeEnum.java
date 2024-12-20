package com.main.comm.code;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum CommCodeEnum {

    ApiResponse_200("CMD_200", "Process Successed"),
    ApiResponse_901("CMD_901", "Service Process Error"),
    ApiResponse_999("CMD_999","Api Process Exception");

    private final String code;
    private final String codeMsg;

    private CommCodeEnum(String code, String codeMsg) {
        this.code = code;
        this.codeMsg = codeMsg;
    }

}
