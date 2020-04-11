package com.controller;

import com.entities.CommonResult;
import com.entities.Payment;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping("/query")
    @ResponseBody
    public CommonResult<Payment> query(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new CommonResult<Payment>("0000","",new Payment(1, UUID.randomUUID().toString()));
    }

    @RequestMapping("/discovery")
    @ResponseBody
    public Map discovery(){

        Map map = new HashMap();
        List<String> services = discoveryClient.getServices();
        services.stream().forEach( e -> {
            System.out.println("service: " + e);
        });

        List<ServiceInstance> instances = discoveryClient.getInstances("cloud.provider.payment.9001");
        instances.stream().forEach( e -> {
            String instance = e.getServiceId() + " " + e.getInstanceId() + " " + e.getUri();
            System.out.println("instance: " + instance);
        });
        map.put("discoveryClient",discoveryClient);
        return map;
    }
}
