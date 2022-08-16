package com.jchao.springcloud.service;

import java.math.BigDecimal;

/**
 * @author ChangJinchao
 * @create 2022-08-13 10:43
 * @Description
 */
public interface AccountService  {
    /**
     * 修改账户余额
     */
    int updataAccount(Long userId,BigDecimal used);

    int dispachter(Long userId,BigDecimal used);
}
