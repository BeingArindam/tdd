package com.home.demo.tdd.testDriven.transformer;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

import com.home.demo.tdd.testDriven.domain.OrderSummary;
import com.home.demo.tdd.testDriven.entity.OrderEntity;
import com.home.demo.tdd.testDriven.entity.OrderItemEntity;

public class OrderEntityToOrderSummaryTransformerTest {
	private OrderEntityToOrderSummaryTransformer target = null;

	@Before
	public void setup() {
		target = new OrderEntityToOrderSummaryTransformer();
	}

	@Test
	public void test_transform() {
		String orderNumberFixture = UUID.randomUUID().toString();
		
		OrderEntity orderEntityFixture = new OrderEntity();
		orderEntityFixture.setOrderNumber(orderNumberFixture);
		orderEntityFixture.setOrderList(new LinkedList<OrderItemEntity>());
		
		OrderItemEntity itemFixture1 = new OrderItemEntity();
		itemFixture1.setQuantity(1);
		itemFixture1.setSellingPrice(BigDecimal.valueOf(15.00));
		orderEntityFixture.getOrderList().add(itemFixture1);
		
		OrderItemEntity itemFixture2 = new OrderItemEntity();
		itemFixture2.setQuantity(2);
		itemFixture2.setSellingPrice(BigDecimal.valueOf(2.50));
		orderEntityFixture.getOrderList().add(itemFixture2);
		
		OrderSummary result = target.transform(orderEntityFixture);
		assertNotNull(result);
		assertEquals(orderNumberFixture, result.getOrderNumber());
		assertEquals(3, result.getItemCount());
		assertEquals(new BigDecimal("20.00"), result.getTotalAmount());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_transform_inputIsNull(){
		target.transform(null);
	}
	
	@Test
	public void test_transform_with_no_item() {
		String orderNumberFixture = UUID.randomUUID().toString();
		
		OrderEntity orderEntityFixture = new OrderEntity();
		orderEntityFixture.setOrderNumber(orderNumberFixture);
		orderEntityFixture.setOrderList(new LinkedList<OrderItemEntity>());
	
		
		OrderSummary result = target.transform(orderEntityFixture);
		assertNotNull(result);
		assertEquals(orderNumberFixture, result.getOrderNumber());
		assertEquals(0, result.getItemCount());
		assertEquals(new BigDecimal("0.00"), result.getTotalAmount());
	}
	
}
