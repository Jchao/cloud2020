package com.jchao.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

/**
 * @author ChangJinchao
 * @create 2022-07-02 19:02
 */

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "服务调用失败，提示来自：cloud-consumer-feign-order80";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "服务调用失败 超时or运行异常，提示来自：cloud-consumer-feign-order80";
    }

    @Override
    public String paymentCircuit(Integer id) {
        return "服务调用失败 超时or运行异常，提示来自：cloud-consumer-feign-order80";
    }
}
