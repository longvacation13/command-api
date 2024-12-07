package com.main.comm.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommResDto<T> { //Generic은 클래스가 사용될때 결정됨

    private String resultCode;
    private T resultData;
    private String message;

    public CommResDto(String resultCode, T resultData, String message) {
        this.resultCode = resultCode;
        this.resultData = resultData;
        this.message    = message;
    }

    public static class Builder<T> {
        private String resultCode;
        private T resultData;
        private String message;

        public Builder<T> resultCode(String resultCode) {
            this.resultCode = resultCode;
            return this;
        }

        public Builder<T> resultData(T resultData) {
            this.resultData = resultData;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public CommResDto<T> build() {
            return new CommResDto<>(resultCode, resultData, message);
        }
    }
}
