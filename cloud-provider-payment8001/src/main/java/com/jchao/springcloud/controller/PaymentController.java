package com.jchao.springcloud.controller;

import com.jchao.springcloud.entities.CommonResult;
import com.jchao.springcloud.entities.Payment;
import com.jchao.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.omg.CORBA.TIMEOUT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resources;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping(value = {"/payment/create"})
    public CommonResult savePayment(@RequestBody Payment payment){
        log.info("Payment{}",payment);
        int res = paymentService.create(payment);
        log.info("*****结果：{}",res);
        if (res > 0){
            return new CommonResult(200,"添加成功,port:"+port,res);
        }else {
            return new CommonResult(404,"添加失败",res);
        }
    }

    @GetMapping(value = {"/payment/get/{id}"})
    public CommonResult getOnePayment(@PathVariable("id") Integer id){
        Payment payment = null;
        try {
            payment = paymentService.getPaymentById(id);
        } catch (Exception e) {
            System.out.println("异常");
            e.printStackTrace();
        }
        log.info("*****查询数据结果：{}",payment);
        if (payment != null){
            System.out.println("不空");
            return new CommonResult(200,"查询结果成功,port:"+port,payment);
        }else{
            return new CommonResult(404,"查询结果失败",null);
        }
    }

    @GetMapping(value = {"/payment/fegin/timeout"})
    public String feginTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }

}
