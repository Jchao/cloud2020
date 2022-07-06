package com.jchao.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.jchao.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;


/**
 * @author ChangJinchao
 * @create 2022-07-02 16:02
 */
@Service
@DefaultProperties(defaultFallback = "paymentInfo_TimeOutHandler")
public class PaymentServiceImpl implements PaymentService {

    /**
     * 正常访问，一切OK
     * @param id
     * @return
     */
    @Override
    public String paymentInfo_OK(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_OK,id: " + id + "\t" + "O(∩_∩)O";
    }

    /**
     * 超时访问，演示降级
     * @param id
     * @return
     */
    @Override
    //服务降级  超过3秒
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="3000")
    })
    public String paymentInfo_TimeOut(Integer id) {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池:" + Thread.currentThread().getName() + "paymentInfo_TimeOut,id: " + id + "\t" + "O(∩_∩)O，耗费4秒";
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60") //
    })
    @Override
    public String paymentCircuitBreaker(Integer id) {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }

    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }

    /**
     * 兜底方法  //参数相同不然
     * 报错：
     * fallback method wasn't found: paymentInfo_TimeOutHandler([class java.lang.Integer])
     * 问题所在：臃肿
     * ①兜底方法与逻辑方法在一起
     * ②每个降级都需要一个兜底方法？
     * @return
     */
    public String paymentInfo_TimeOutHandler(Integer id){
        return "controller层调用超时或者异常 当前线程名称："+ Thread.currentThread().getName() +"/(ㄒoㄒ)/~~";
    }

    //全局fallback
    public String payment_Global_FallbackMethod()
    {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }
}
