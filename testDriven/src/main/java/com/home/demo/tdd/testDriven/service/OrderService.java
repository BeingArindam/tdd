package com.home.demo.tdd.testDriven.service;

import java.util.List;

import org.hibernate.service.spi.ServiceException;

import com.home.demo.tdd.testDriven.domain.OrderSummary;

public interface OrderService {
	public List<OrderSummary> getOrderSummery(long customerId) throws ServiceException;
}
