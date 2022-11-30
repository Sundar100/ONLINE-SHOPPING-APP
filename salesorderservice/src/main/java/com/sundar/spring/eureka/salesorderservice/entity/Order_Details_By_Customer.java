package com.sundar.spring.eureka.salesorderservice.entity;

public class Order_Details_By_Customer {
	private Long order_id;
	private String order_desc;

	public Order_Details_By_Customer() {

	}

	public Order_Details_By_Customer(Long order_id, String order_desc) {
		super();
		this.order_id = order_id;
		this.order_desc = order_desc;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public String getOrder_desc() {
		return order_desc;
	}

	public void setOrder_desc(String order_desc) {
		this.order_desc = order_desc;
	}

	@Override
	public String toString() {
		return "Order_Details_By_Customer [order_id=" + order_id + ", order_desc=" + order_desc + "]";
	}

}
