package com.jchao.springcloud.service;

/**
 * @author ChangJinchao
 * @create 2022-08-13 9:36
 * @Description
 */
public interface StorageService {

    /**
     * 扣减库存
     */

    int decrease(Long productId, Integer count);
}
