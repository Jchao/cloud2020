package com.jchao.springcloud;

import com.jchao.springcloud.controller.OrderController;
import com.jchao.springcloud.entities.CommonResult;
import com.jchao.springcloud.service.OrderServiceFeign;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class MockTest {

    @InjectMocks
    private OrderController orderController = new OrderController();

    @Mock
    private OrderServiceFeign orderServiceFeign;

    @Test
    public void test(){
        System.out.println("ok1");
        CommonResult commonResult = new CommonResult();
        Mockito.when(orderServiceFeign.getOnePayment(1)).thenReturn(commonResult);
        orderController.getOnePayment(1);
    }
}
