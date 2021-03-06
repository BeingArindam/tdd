/**
 * 
 */
package com.home.demo.tdd.testDriven.entity;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Arindam
 *
 */
@Entity
public class OrderEntity {
	@Id
	private long id;
	@Column
	private String orderNumber;
	@Column
	private String orderLabel;
	@Column
	private long customerId;
	@Column
	private long shippingAddressId;
	@Column
	private long billingAddressId;
	@Column
	private Date completionDate;
	@OneToMany
	private List<OrderItemEntity> orderList = new LinkedList<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderLabel() {
		return orderLabel;
	}

	public void setOrderLabel(String orderLabel) {
		this.orderLabel = orderLabel;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public long getBillingAddressId() {
		return billingAddressId;
	}

	public void setBillingAddressId(long billingAddressId) {
		this.billingAddressId = billingAddressId;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public List<OrderItemEntity> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderItemEntity> orderList) {
		this.orderList = orderList;
	}

	public long getShippingAddressId() {
		return shippingAddressId;
	}

	public void setShippingAddressId(long shippingAddressId) {
		this.shippingAddressId = shippingAddressId;
	}
}
