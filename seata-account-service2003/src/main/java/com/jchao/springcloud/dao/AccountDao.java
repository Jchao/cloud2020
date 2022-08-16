package com.jchao.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author ChangJinchao
 * @create 2022-08-13 10:37
 * @Description
 */
@Mapper
public interface AccountDao {
    /**
     * 修改账户余额
     */
    int updataAccount(@Param("userId") Long userId, @Param("used") BigDecimal used);
}
