package com.jchao.springcloud;

import com.jchao.springcloud.dao.OrderDao;
import com.jchao.springcloud.domain.Order;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author ChangJinchao
 * @create 2022-08-12 21:12
 * @Description
 */

@SpringBootTest(classes = SeataOrderMainApp2001.class)
public class OrderServiceTest {

    @Resource
    private OrderDao orderDao;

    @Test
    public void createTest(){
        Order order = new Order();
        order.setCount(1);
        order.setMoney(new BigDecimal("23"));
        order.setProductId(1L);
        order.setUserId(111L);
        System.out.println(orderDao);
        //orderDao.create(order);
        //System.out.println(order);
    }
}
