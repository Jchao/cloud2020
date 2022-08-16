package com.jchao.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ChangJinchao
 * @create 2022-08-13 9:29
 * @Description
 */
@Mapper
public interface StorageDao {
    /**
     * 扣减库存
     */

    int decrease(@Param("productId") Long productId,@Param("count") Integer count);
}
