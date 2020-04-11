package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 进入hystrixDashboard页面
 * http://localhost:6001/hystrix
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApplication6001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboardApplication6001.class,args);
    }
}
