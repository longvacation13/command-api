package com.main.order.controller;

import com.main.comm.dto.CommResDto;
import com.main.comm.dto.ResponseDto;
import com.main.discount.service.DiscountService;
import com.main.order.dto.OrderRequest;
import com.main.order.service.OrderService;
import com.main.test.service.CommHttpService;
import com.main.test.service.impl.ExampleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@AllArgsConstructor
public class OrderController {

    private CommHttpService commHttpService;

    private DiscountService discountService;

    private ExampleService exampleService;

    private OrderService orderService;

    @GetMapping(value = "/order", produces="application/json")
    public ResponseDto<CommResDto> testOrderApi(@RequestParam(required = false) @Valid String preOrderId) throws Exception {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setPreOrderId(preOrderId);
        orderService.createOrder(orderRequest);

        return new ResponseDto.Builder<CommResDto>()
                              .status(HttpStatus.OK.value())
                              .message(HttpStatus.OK.getReasonPhrase())
                              .build();
    }
}
