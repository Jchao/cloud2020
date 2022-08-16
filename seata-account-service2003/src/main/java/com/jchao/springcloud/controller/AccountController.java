package com.jchao.springcloud.controller;

import com.jchao.springcloud.domain.CommonResult;
import com.jchao.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author ChangJinchao
 * @create 2022-08-13 10:44
 * @Description
 */
@RestController
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 扣减账户余额
     */
    @RequestMapping("/account/decrease")
    public CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money") BigDecimal money) {
        log.info("入参:userId:{},money:{}",userId,money);
        int result = accountService.updataAccount(userId, money);
        if (result <= 0){
            return new CommonResult(404, "扣减账户余额失败！");
        }
        return new CommonResult(200, "扣减账户余额成功！");
    }

    @RequestMapping("/account/decrease1")
    public CommonResult decrease1(@RequestBody Map<String,Object> params) {
        Long userId = Long.valueOf((String) params.get("userId"));
        BigDecimal money = new BigDecimal(String.valueOf(params.get("money")));
        int result = accountService.updataAccount(userId, money);
        if (result <= 0){
            return new CommonResult(404, "扣减账户余额失败！");
        }
        return new CommonResult(200, "扣减账户余额成功！");
    }

}
