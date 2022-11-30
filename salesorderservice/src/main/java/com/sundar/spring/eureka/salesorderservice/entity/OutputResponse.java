package com.sundar.spring.eureka.salesorderservice.entity;

import java.util.List;

public class OutputResponse {

	private Long order_id;
	private String order_description;
	private List<OrderLineDTO> orderlinedto;

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public String getOrder_description() {
		return order_description;
	}

	public void setOrder_description(String order_description) {
		this.order_description = order_description;
	}

	public List<OrderLineDTO> getOrderLineItems() {
		return orderlinedto;
	}

	public void setOrderLineItems(List<OrderLineDTO> orderlinedto) {
		this.orderlinedto = orderlinedto;
	}

}
