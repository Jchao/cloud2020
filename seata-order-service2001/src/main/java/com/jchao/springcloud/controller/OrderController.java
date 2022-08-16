package com.jchao.springcloud.controller;

import com.jchao.springcloud.dao.OrderDao;
import com.jchao.springcloud.domain.CommonResult;
import com.jchao.springcloud.domain.Order;
import com.jchao.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChangJinchao
 * @create 2022-08-12 20:51
 * @Description
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDao orderDao;

    @PostMapping("/order/create")
    public CommonResult<String> create(@RequestBody Order order){
       log.info("下单入参：{}",order);
        int result = orderService.create(order);
        if (result <= 0){
            return new CommonResult(404, "订单创建失败!");
        }
        return new CommonResult(200, "订单创建成功!");
    }

    @GetMapping("/orderDao")
    public String orderDao(){
        return orderDao.toString();
    }
}
