package com.project.mall.order;

import com.project.mall.order.entity.OrderEntity;
import com.project.mall.order.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MallOrderApplicationTests {
    @Autowired
    OrderService orderService;

    @Test
    void contextLoads() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(1L);
        orderEntity.setBillType(3);
        orderService.updateById(orderEntity);
        System.out.println("修改成功");
    }

}
