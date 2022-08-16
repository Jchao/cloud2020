package com.jchao.springcloud.service;

import com.jchao.springcloud.domain.Order;

/**
 * @author ChangJinchao
 * @create 2022-08-12 20:32
 * @Description
 */
public interface OrderService {
    /**
     * 创建订单
     */
    int create(Order order);

    /**
     * 修改订单状态
     */
    int updataStatus(Long id, Integer status);
}
