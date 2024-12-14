package com.main.discount.service;

public class CouponDiscount extends Discount {

    @Override
    public void createDiscountDtl() {
        System.out.println("coupon 할인에 대한 discount_dtl 테이블 생성합니다.");
    }

    @Override
    public void createDiscountTarget() {
        System.out.println("coupon 할인에 대한 discount_target 테이블 생성합니다.");
    }
}
