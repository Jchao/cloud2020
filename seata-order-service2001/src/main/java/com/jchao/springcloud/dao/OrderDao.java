package com.jchao.springcloud.dao;

import com.jchao.springcloud.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ChangJinchao
 * @create 2022-08-12 20:05
 * @Description
 */
@Mapper
public interface OrderDao {
    /**
     * 创建订单
     */
    int create(Order order);

    /**
     * 修改订单状态
     */
    int updataStatus(@Param("id") Long id, @Param("status") Integer status);
}
