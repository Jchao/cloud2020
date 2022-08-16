package com.jchao.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan({"com.jchao.springcloud.dao"})
public class MyBatisConfig {
}