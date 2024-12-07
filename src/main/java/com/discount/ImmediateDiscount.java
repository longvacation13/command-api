package com.discount;

public class ImmediateDiscount extends Discount {

    @Override
    public void createDiscountDtl() {
        System.out.println("immediate 할인에 대한 discount_dtl 테이블 생성합니다.");
    }

    @Override
    public void createDiscountTarget() {
        System.out.println("immediate 할인에 대한 discount_target 테이블 생성합니다.");
    }
}
