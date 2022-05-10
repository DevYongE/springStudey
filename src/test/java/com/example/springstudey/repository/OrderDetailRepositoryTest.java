package com.example.springstudey.repository;

import com.example.springstudey.SpringStudeyApplicationTests;
import com.example.springstudey.model.entity.OrderDetail;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class OrderDetailRepositoryTest extends SpringStudeyApplicationTests {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create(){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderAt(LocalDateTime.now());
//        orderDetail.setUser("");
//        orderDetail.setItemId(1L);

        OrderDetail newOrderDetail1 = orderDetailRepository.save(orderDetail);
        Assertions.assertNotNull(newOrderDetail1);
    }

}
