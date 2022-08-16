package com.jchao.springcloud.service.Impl;

import com.jchao.springcloud.dao.AccountDao;
import com.jchao.springcloud.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author ChangJinchao
 * @create 2022-08-13 10:43
 * @Description
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public int updataAccount(Long userId, BigDecimal used) {
        //调用第三方支付进行支付
        int result = dispachter(userId, used);
        if (result <= 0){
            //未完成支付
        }
        //调用余额减少
        return accountDao.updataAccount(userId,used);
    }

    @Override
    public int dispachter(Long userId, BigDecimal used) {
        //int i = 9/0;
        return 1;
    }
}
