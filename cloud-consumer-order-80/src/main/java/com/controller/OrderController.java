package com.controller;

import com.entities.CommonResult;
import com.entities.Payment;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.service.feign.PaymentFiegnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final static String PAYMENT_URL = "http://CLOUD-PROVIDER-PAYMENT-9001/payment/query";

    @Resource
    private RestTemplate restTemplate;

    @Autowired
    private PaymentFiegnService paymentFiegnService;

    @RequestMapping("/query")
    @ResponseBody
    public CommonResult<Payment> query(){
        return new CommonResult<Payment>("1000","",new Payment(1, UUID.randomUUID().toString()));
    }

    @RequestMapping("/rest/template")
    @ResponseBody
    public Map restTemplate(){

        Map map = new HashMap();
        CommonResult<Payment> object = restTemplate.postForObject(PAYMENT_URL, null, CommonResult.class);
        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL, null, CommonResult.class);
        map.put("object",object);
        map.put("entity",entity);
        return map;
    }

    @RequestMapping("/feign/query")
    @ResponseBody
    public CommonResult<Payment> feignQuery(){
        return paymentFiegnService.query();
    }
}
