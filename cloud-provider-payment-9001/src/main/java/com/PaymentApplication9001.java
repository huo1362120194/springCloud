package com;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableCircuitBreaker
public class PaymentApplication9001 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication9001.class,args);
    }

    /*
     * 此配置是为了服务监控，与服务器容错无关，springCloud升级后的坑
     * ServletRegistrationBean因为springboot的默认路径不是"/hystrix.stream"
     */
    @Bean
    public ServletRegistrationBean getServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("hystrixMetricsStreamServlet");
        return registrationBean;
    }

}


