package com.home.demo.tdd.testDriven.service.impl;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.home.demo.tdd.testDriven.dao.OrderDao;
import com.home.demo.tdd.testDriven.domain.OrderSummary;
import com.home.demo.tdd.testDriven.entity.OrderEntity;
import com.home.demo.tdd.testDriven.transformer.OrderEntityToOrderSummaryTransformer;

public class OrderServiceImplTest {
	private final static long CUSTOMER_ID = 1L;
	@Mock
	protected OrderDao orderDao;

	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetOrderSummery() {
		OrderServiceImpl target = new OrderServiceImpl();

		target.setOrderDao(orderDao);

		OrderEntityToOrderSummaryTransformer mockTransformer = Mockito.mock(OrderEntityToOrderSummaryTransformer.class);
		target.setTransformer(mockTransformer);
		
		OrderEntity orderEntityFixture = new OrderEntity();
		List<OrderEntity> orderEntityListFixture = new LinkedList<>();
		orderEntityListFixture.add(orderEntityFixture);

		Mockito.when(orderDao.findOrdersByCustomer(CUSTOMER_ID)).thenReturn(orderEntityListFixture);
		
		OrderSummary orderSummaryFixture = new OrderSummary();
		Mockito.when(mockTransformer.transform(orderEntityFixture)).thenReturn(orderSummaryFixture);
		
		List<OrderSummary> result = target.getOrderSummery(CUSTOMER_ID);
		
		Mockito.verify(orderDao).findOrdersByCustomer(CUSTOMER_ID);
		Mockito.verify(mockTransformer).transform(orderEntityFixture);

		assertNotNull(result);
		assertEquals(1, result.size());
		assertSame(orderSummaryFixture, result.get(0));
	}

}
