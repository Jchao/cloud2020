package com.jchao.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jchao.springcloud.entities.CommonResult;
import com.jchao.springcloud.entities.Payment;
import com.jchao.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ChangJinchao
 * @create 2022-08-09 21:23
 * @Description
 */
@RestController
public class CircleBreakerController {

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/openfeign/{id}")
    @SentinelResource(value = "openfeign")
    public CommonResult<Payment> openfeign(@PathVariable Long id) {
        CommonResult<Payment> result = paymentService.paymentSQL(id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常....");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录,空指针异常");
        }
        return result;
    }

    @GetMapping(value = "/consumer/openfeign1/{id}")
    @SentinelResource(value = "openfeign1",fallback = "handlerFallback")
    public CommonResult<Payment> openfeign1(@PathVariable Long id) {
        CommonResult<Payment> result = paymentService.paymentSQL(id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常....");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录,空指针异常");
        }
        return result;
    }

    @GetMapping(value = "/consumer/openfeign2/{id}")
    @SentinelResource(value = "openfeign2",blockHandler = "blockHandler")
    public CommonResult<Payment> openfeign2(@PathVariable Long id) {
        CommonResult<Payment> result = paymentService.paymentSQL(id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常....");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录,空指针异常");
        }
        return result;
    }

    @GetMapping(value = "/consumer/openfeign3/{id}")
    @SentinelResource(value = "openfeign3",blockHandler = "blockHandler",fallback = "handlerFallback")
    public CommonResult<Payment> openfeign3(@PathVariable Long id) {
        CommonResult<Payment> result = paymentService.paymentSQL(id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常....");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException,该ID没有对应记录,空指针异常");
        }
        return result;
    }

    public CommonResult handlerFallback(@PathVariable  Long id,Throwable e) {
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(444,"兜底异常handlerFallback,exception内容  "+e.getMessage(),payment);
    }

    public CommonResult blockHandler(@PathVariable  Long id, BlockException blockException) {
        Payment payment = new Payment(id,"null");
        return new CommonResult<>(445,"blockHandler-sentinel限流,无此流水: blockException  "+blockException.getMessage(),payment);
    }
}
