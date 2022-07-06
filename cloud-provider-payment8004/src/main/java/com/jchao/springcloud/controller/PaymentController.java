package com.jchao.springcloud.controller;

import com.jchao.springcloud.entities.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
public class PaymentController
{
    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/zk")
    public CommonResult paymentzk()
    {
        return new CommonResult(200,"springcloud with zookeepe,port:"+serverPort,UUID.randomUUID().toString());
    }
}