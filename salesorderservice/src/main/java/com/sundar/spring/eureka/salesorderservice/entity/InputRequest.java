package com.sundar.spring.eureka.salesorderservice.entity;

import java.util.List;

public class InputRequest {

	private String order_desc;
	private String order_date;
	private Long cust_id;
	private List<String> items;

	public InputRequest(String order_desc, String order_date, Long cust_id, List<String> items) {
		super();
		this.order_desc = order_desc;
		this.order_date = order_date;
		this.cust_id = cust_id;
		this.items = items;
	}

	public String getOrder_desc() {
		return order_desc;
	}

	public void setOrder_desc(String order_desc) {
		this.order_desc = order_desc;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public Long getCust_id() {
		return cust_id;
	}

	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "InputRequest [order_desc=" + order_desc + ", order_date=" + order_date + ", cust_id=" + cust_id
				+ ", items=" + items + "]";
	}

}
