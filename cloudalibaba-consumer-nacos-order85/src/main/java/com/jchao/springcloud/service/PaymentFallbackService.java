package com.jchao.springcloud.service;

import com.jchao.springcloud.entities.CommonResult;
import com.jchao.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @author ChangJinchao
 * @create 2022-08-09 21:22
 * @Description
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回,没有该流水信息",new Payment(id, "errorSerial......"));
    }
}
