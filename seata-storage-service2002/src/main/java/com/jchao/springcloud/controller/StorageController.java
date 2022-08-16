package com.jchao.springcloud.controller;

import com.jchao.springcloud.domain.CommonResult;
import com.jchao.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Slf4j
public class StorageController {

    @Autowired
    private StorageService storageService;

    /**
     * 扣减库存
     */
    @RequestMapping("/storage/decrease")
    public CommonResult decrease( Long productId, Integer count) {
        log.info("入参：productId:{},count:{}",productId,count);
        int result = storageService.decrease(productId, count);
        if (result <= 0) {
            return new CommonResult(404, "扣减库存失败！");
        }
        return new CommonResult(200, "扣减库存成功！");
    }

    @RequestMapping("/storage/decrease1")
    public CommonResult decrease1(@RequestBody Map<String,Object> params) {
        log.info("入参:{}",params);
        Long productId = Long.valueOf((String) params.get("productId"));
        Integer count = Integer.valueOf((String) params.get("count"));
        int result = storageService.decrease(productId, count);
        if (result <= 0) {
            return new CommonResult(404, "扣减库存失败！");
        }
        return new CommonResult(200, "扣减库存成功！");
    }
}