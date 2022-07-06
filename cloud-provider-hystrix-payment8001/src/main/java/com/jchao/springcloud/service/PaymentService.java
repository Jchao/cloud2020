package com.jchao.springcloud.service;

/**
 * @author ChangJinchao
 * @create 2022-07-02 16:01
 */
public interface PaymentService {
    String paymentInfo_OK(Integer id);
    String paymentInfo_TimeOut(Integer id);
    String paymentCircuitBreaker(Integer id);
}
