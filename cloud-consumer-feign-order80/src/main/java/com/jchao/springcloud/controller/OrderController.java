package com.jchao.springcloud.controller;

import com.jchao.springcloud.entities.CommonResult;
import com.jchao.springcloud.service.OrderServiceFeign;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderController {

    @Resource
    private OrderServiceFeign orderServiceFeign;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getOnePayment(@PathVariable long id){
        //调用provider模块的controller  restTemplate
        return orderServiceFeign.getOnePayment((int) id);
    }

    @GetMapping(value = {"/consumer/payment/fegin/timeout"})
    public String feginTimeout(){
        return orderServiceFeign.feginTimeout();
    }
}
