package com.jchao.springcloud.service.impl;

import com.jchao.springcloud.dao.OrderDao;
import com.jchao.springcloud.domain.Order;
import com.jchao.springcloud.service.AccountService;
import com.jchao.springcloud.service.OrderService;
import com.jchao.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ChangJinchao
 * @create 2022-08-12 20:33
 * @Description
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private StorageService storageService;
    //
    @Autowired
    private AccountService accountService;


    @Override
    @GlobalTransactional(name = "osa-create-order",rollbackFor = Exception.class)
    public int create(Order order) {
        //1号user 购买 a号商品2件 总共80元 账户-
        //用户下单->创建订单——>商品库存减少->用户完成支付->用户余额减少
        log.info("创建订单开始...:{}",order);
        orderDao.create(order);
        log.info("调用减少商品库存数量服务....:{}个",order.getCount());
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("调用减少商品库存数量服务完成");
        //int i = 7/0;
        log.info("调用用户支付模块服务...:用户:{},金额:{}",order.getUserId(),order.getMoney());
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("调用用户支付模块服务完成");
        log.info("调用修改订单状态服务...");
        updataStatus(order.getId(), 1);
        log.info("下单结束");
        return 1;
    }

    @Override
    public int updataStatus(Long id, Integer status) {
        return orderDao.updataStatus(id,status);
    }
}
