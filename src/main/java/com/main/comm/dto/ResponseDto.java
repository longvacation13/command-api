package com.main.comm.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto<T> {
    private int status;
    private String message;
    private T data;

    //private final int default$Status  = HttpStatus.OK.value();
    //private final String default$message = HttpStatus.OK.getReasonPhrase();

    private ResponseDto(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    // inner class
    // 외부 클래스의 인스턴스에 종속되지 않음. 외부클래스의 인스턴스 없이 생성 가능
    // 독립성 : static inner class는 외부 클래스의 인스턴스 혹은 메소드 직접 접근 불가
    // 메모리 효율 : 외부 클래스의 인스턴스없이 생성 가능하기 때문에 필요한 때만 내부 클래스 인스턴스 생성하여 메모리 최적화
    // 용도 : 외부 클래스의 인스턴스와 독립적인 동작을 할때 사용함 (쉽게말해 static 멤버에만 접근 가능)
    public static class Builder<T> {
        private int status;
        private String message;
        private T data;

        public Builder<T> status(int status) {
            this.status = status;
            return this;
        }

        public Builder<T> message(String message) {
            this.message = message;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ResponseDto<T> build() {
            return new ResponseDto<>(status, message, data);
        }

    }
}
