package com.discount;


import org.springframework.stereotype.Service;

@Service
public class DiscountService {
    // 쿠폰 종류를 판단하는 팩토리 메서드(공통)
    private Discount findDiscountKind(String discountKind) {
        if("COUPON".equals(discountKind)) {
            return new CouponDiscount();
        }
        else if("POINT".equals(discountKind)) {
            return new PointDiscount();
        }
        else {
            return new ImmediateDiscount();
        }
    }

    public void createDiscount(String discountKind) {
        Discount discount = findDiscountKind(discountKind);
        discount.createDiscount();
    }

}
