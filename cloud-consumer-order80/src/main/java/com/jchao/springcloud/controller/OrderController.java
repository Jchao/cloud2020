package com.jchao.springcloud.controller;

import com.jchao.springcloud.entities.CommonResult;
import com.jchao.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController {

//    public static final String PAYMENT_URL = "http://localhost:8001";  //不能写死
    //通过服务名称来访问
    public static final String PAYMENT_URL = "http://cloud-payment-service";
//    public static final String PAYMENT_URL = "http://localhost:8004";
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment){
        //调用provider模块的controller  restTemplate
        log.info("{}",payment);
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommonResult.class);
    }
    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getOnePayment(@PathVariable long id){
        //调用provider模块的controller  restTemplate
        return restTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,CommonResult.class);
    }

    @GetMapping("/consumer/payment/getEntity/{id}")
    public CommonResult getEntity(@PathVariable long id){
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (entity.getStatusCode().is2xxSuccessful()){
            log.info("Headers:{}",entity.getHeaders());
            return entity.getBody();
        }else{
            return new CommonResult(400,"失败");
        }
    }
    @GetMapping("/consumer/payment/zk")
    public CommonResult zookeeper(){
        //调用provider模块的controller  restTemplate
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zk",CommonResult.class);
    }
}
