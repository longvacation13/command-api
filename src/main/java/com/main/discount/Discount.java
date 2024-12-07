package com.main.discount;

public abstract class Discount {



    // discount 테이블 생성
    public void createDiscount() {
    }

    // discount_dtl 테이블 생성 -> 여기부터는 달라짐
    public abstract void createDiscountDtl();

    // 여기도 달라짐
    public abstract void createDiscountTarget();

}
