package com.jchao.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.jchao.springcloud.entities.CommonResult;

/**
 * @author ChangJinchao
 * @create 2022-08-09 19:49
 * @Description
 */

public class CustomerBlockHandler {

    public static CommonResult handleException(BlockException exception){
        return new CommonResult(2020,"自定义的限流处理信息......CustomerBlockHandler");
    }

    public static CommonResult handleException2(BlockException exception){
        return new CommonResult(444,"自定义的限流处理信息......CustomerBlockHandler222");
    }
}
