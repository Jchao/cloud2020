package com.jchao.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author ChangJinchao
 * @create 2022-08-05 19:16
 * @Description
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
        //try {
        //    TimeUnit.MILLISECONDS.sleep(1000);
        //}catch (InterruptedException e){
        //    e.printStackTrace();
        //}
        log.info("{}",Thread.currentThread());
        return "------testA";
    }
    @GetMapping("/testB")
    public String testB(){
        log.info("{}",Thread.currentThread().getName());
        return "------testB";
    }

    @GetMapping("/testD")
    public String testD(){
        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(1); } catch (InterruptedException e) { e.printStackTrace(); }
        log.info("testD 测试RT");
        return "------testD";
    }

    @GetMapping("/testE")
    public String testE(){
        log.info("testE 测试异常数");
        int age = 10/0;
        return "------testE";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "HotKey1", blockHandler = "HotKey1BlockHandler",fallback = "HotKey1Fallback")
    public String testHotKey(@RequestParam(value = "p1" ,required = false) String p1,@RequestParam(value = "p2" ,required = false) String p2){
        if (StringUtils.isNotEmpty(p1)){
            return "------testHotKey,p1="+p1;
        }
        int i = 1/0;
        return "------testHotKey";
    }

    public String HotKey1BlockHandler(String param1, String param2, BlockException exception){
        return "-----dealHandler_testHotKey";
    }

    public String HotKey1Fallback(String param1, String param2){
        return "---------HotKey1Fallback";
    }
}
