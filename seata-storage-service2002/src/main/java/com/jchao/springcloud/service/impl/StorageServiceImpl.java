package com.jchao.springcloud.service.impl;

import com.jchao.springcloud.dao.StorageDao;
import com.jchao.springcloud.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ChangJinchao
 * @create 2022-08-13 9:37
 * @Description
 */
@Service
public class StorageServiceImpl implements StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Autowired
    private StorageDao storageDao;

    @Override
    public int decrease(Long productId, Integer count) {
        LOGGER.info("------->storage-service中扣减库存开始");
        int reuslt = storageDao.decrease(productId, count);
        //int i = 88/0;
        return reuslt;
    }
}
