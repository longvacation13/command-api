package com.main.discount;

public class PointDiscount extends Discount {

    @Override
    public void createDiscountDtl() {
        System.out.println("point 할인에 대한 discount_dtl 테이블 생성합니다.");
    }

    @Override
    public void createDiscountTarget() {
        System.out.println("point 할인에 대한 discount_target 테이블 생성합니다.");
    }
}
