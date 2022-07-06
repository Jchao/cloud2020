package com.jchao.springcloud.service;

import com.jchao.springcloud.entities.CommonResult;
import com.jchao.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OrderServiceFeign {

    @GetMapping(value = {"/payment/get/{id}"})
    public CommonResult getOnePayment(@PathVariable("id") Integer id);

    @GetMapping(value = {"/payment/fegin/timeout"})
    public String feginTimeout();
}
