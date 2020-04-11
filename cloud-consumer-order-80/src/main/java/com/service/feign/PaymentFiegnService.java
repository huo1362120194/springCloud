package com.service.feign;

import com.entities.CommonResult;
import com.entities.Payment;
import com.service.impl.OrderFallbackServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * openFeign默认等待1秒
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT-9001",path = "/payment",fallback = OrderFallbackServiceImpl.class)
public interface PaymentFiegnService {

    @RequestMapping("/query")
    public CommonResult<Payment> query();
}
