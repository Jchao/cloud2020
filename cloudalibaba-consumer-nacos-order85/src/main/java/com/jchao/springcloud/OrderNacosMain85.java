package com.jchao.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ChangJinchao
 * @create 2022-08-09 20:37
 * @Description
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class OrderNacosMain85 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosMain85.class,args);
    }
}
