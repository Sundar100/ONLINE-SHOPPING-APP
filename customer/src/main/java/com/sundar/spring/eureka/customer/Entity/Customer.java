package com.sundar.spring.eureka.customer.Entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue
	private Long id;
	private String email;
	private String first_name;
	private String last_name;

	public Customer() {

	}

	public Customer(String email, String first_name, String last_name) {
		super();
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", email=" + email + ", first_name=" + first_name + ", last_name=" + last_name
				+ "]";
	}

}
