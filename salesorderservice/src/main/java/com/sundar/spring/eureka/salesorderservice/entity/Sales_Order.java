package com.sundar.spring.eureka.salesorderservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sales_Order {
	@Id
	private Long id;
	private String order_date;
	private Long cust_id;
	private String order_desc;
	private double total_price;

	public Sales_Order() {

	}

	public Sales_Order(Long id, String order_date, Long cust_id, String order_desc, double total_price) {
		super();
		this.id = id;
		this.order_date = order_date;
		this.cust_id = cust_id;
		this.order_desc = order_desc;
		this.total_price = total_price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public String getOrder_desc() {
		return order_desc;
	}

	public void setOrder_desc(String order_desc) {
		this.order_desc = order_desc;
	}

	public double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(double total_price) {
		this.total_price = total_price;
	}

	@Override
	public String toString() {
		return "Sales_Order [id=" + id + ", order_date=" + order_date + ", cust_id=" + cust_id + ", order_desc="
				+ order_desc + ", total_price=" + total_price + "]";
	}

}
