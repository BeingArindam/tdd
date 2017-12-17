package com.home.demo.tdd.testDriven.dao;

import java.util.List;

import com.home.demo.tdd.testDriven.entity.OrderEntity;

public interface OrderDao {

	List<OrderEntity> findOrdersByCustomer(long customerId);

}
