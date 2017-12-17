package com.home.demo.tdd.testDriven.transformer;

import java.math.BigDecimal;

import com.home.demo.tdd.testDriven.domain.OrderSummary;
import com.home.demo.tdd.testDriven.entity.OrderEntity;
import com.home.demo.tdd.testDriven.entity.OrderItemEntity;

public class OrderEntityToOrderSummaryTransformer {

	/**
	 * @param orderEntity
	 * @return
	 */
	public OrderSummary transform(OrderEntity orderEntity) {
		if(orderEntity == null){
			throw new IllegalArgumentException("Null not allowed");
		}
		OrderSummary orderSummary = new OrderSummary();
		orderSummary.setOrderNumber(orderEntity.getOrderNumber());
		int count = 0;
		BigDecimal totalAmount = new BigDecimal("0.00");
		for (OrderItemEntity item : orderEntity.getOrderList()) {
			count += item.getQuantity();
			BigDecimal qty = BigDecimal.valueOf(item.getQuantity());
			BigDecimal price = item.getSellingPrice().multiply(qty);
			totalAmount = totalAmount.add(price);
		}
		orderSummary.setItemCount(count);
		orderSummary.setTotalAmount(totalAmount);
		
		
		return orderSummary;
	}

}
