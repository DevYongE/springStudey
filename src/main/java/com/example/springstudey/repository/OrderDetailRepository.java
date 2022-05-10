package com.example.springstudey.repository;

import com.example.springstudey.model.entity.OrderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long> {
}
