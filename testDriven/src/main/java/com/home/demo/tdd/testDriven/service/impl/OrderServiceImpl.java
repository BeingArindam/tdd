package com.home.demo.tdd.testDriven.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.service.spi.ServiceException;

import com.home.demo.tdd.testDriven.dao.OrderDao;
import com.home.demo.tdd.testDriven.domain.OrderSummary;
import com.home.demo.tdd.testDriven.entity.OrderEntity;
import com.home.demo.tdd.testDriven.service.OrderService;
import com.home.demo.tdd.testDriven.transformer.OrderEntityToOrderSummaryTransformer;

public class OrderServiceImpl implements OrderService {
	private OrderDao orderDao = null;
	private OrderEntityToOrderSummaryTransformer transformer = null;

	public void setOrderDao(final OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public void setTransformer(final OrderEntityToOrderSummaryTransformer transformer) {
		this.transformer = transformer;
	}

	@Override
	public List<OrderSummary> getOrderSummery(long customerId) throws ServiceException {
		List<OrderSummary> resultList = new LinkedList<>();
		List<OrderEntity> orderEntities = this.orderDao.findOrdersByCustomer(customerId);
		resultList = orderEntities.stream().map(item -> transformer.transform(item)).collect(Collectors.toList());
		return resultList;
	}

}
