package com.service.impl;

import com.entities.CommonResult;
import com.entities.Payment;
import com.service.feign.PaymentFiegnService;
import org.springframework.stereotype.Component;

@Component
public class OrderFallbackServiceImpl implements PaymentFiegnService {

    @Override
    public CommonResult<Payment> query() {
        return new CommonResult<Payment>("2001","OrderFallbackServiceImpl query method fallback.",null);
    }
}
