package com.sundar.spring.eureka.salesorderservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Order_Line_Item {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id1;
	private String item_name;
	private int item_quantity;
	private Long order_id;

	public Order_Line_Item() {

	}

	public Order_Line_Item(Long id, String item_name, int item_quantity, Long order_id) {
		super();
		this.id1 = id;
		this.item_name = item_name;
		this.item_quantity = item_quantity;
		this.order_id = order_id;
	}

	public Long getId() {
		return id1;
	}

	public void setId(Long id) {
		this.id1 = id;
	}

	public String getItem_name() {
		return item_name;
	}

	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}

	public int getItem_quantity() {
		return item_quantity;
	}

	public void setItem_quantity(int item_quantity) {
		this.item_quantity = item_quantity;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	@Override
	public String toString() {
		return "Order_Line_Item [id=" + id1 + ", item_name=" + item_name + ", item_quantity=" + item_quantity
				+ ", order_id=" + order_id + "]";
	}

}
