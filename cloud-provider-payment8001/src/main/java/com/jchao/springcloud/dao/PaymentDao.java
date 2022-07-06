package com.jchao.springcloud.dao;

import com.jchao.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {
    /**
     * 添加一条
     */
    public int create(Payment payment);

    /**
     * 通过id查询
     */

    public Payment getPaymentById(@Param("id") long id);
}
