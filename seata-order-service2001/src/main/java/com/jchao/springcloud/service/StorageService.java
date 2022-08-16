package com.jchao.springcloud.service;

import com.jchao.springcloud.domain.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ChangJinchao
 * @create 2022-08-13 10:59
 * @Description openFeign 调用远程接口
 */
@Component
@FeignClient(value = "seata-storage-service")
public interface StorageService {

    // 减库存
    @PostMapping("/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);

}
