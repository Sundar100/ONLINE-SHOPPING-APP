package com.sundar.spring.eureka.customer.sos.Entity;

public class Customer_SOS {

	private Long cust_id;
	private String cust_email;
	private String cust_first_name;
	private String cust_last_name;

	public Customer_SOS() {

	}

	public Customer_SOS(Long cust_id, String cust_first_name, String cust_last_name, String cust_email) {
		super();
		this.cust_id = cust_id;
		this.cust_first_name = cust_first_name;
		this.cust_last_name = cust_last_name;
		this.cust_email = cust_email;
	}

	public Long getCust_id() {
		return cust_id;
	}

	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}

	public String getCust_first_name() {
		return cust_first_name;
	}

	public void setCust_first_name(String cust_first_name) {
		this.cust_first_name = cust_first_name;
	}

	public String getCust_last_name() {
		return cust_last_name;
	}

	public void setCust_last_name(String cust_last_name) {
		this.cust_last_name = cust_last_name;
	}

	public String getCust_email() {
		return cust_email;
	}

	public void setCust_email(String cust_email) {
		this.cust_email = cust_email;
	}

	@Override
	public String toString() {
		return "Customer_SOS [cust_id=" + cust_id + ", cust_first_name=" + cust_first_name + ", cust_last_name="
				+ cust_last_name + ", cust_email=" + cust_email + "]";
	}

}
