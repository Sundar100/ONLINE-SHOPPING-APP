package com.sundar.spring.eureka.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sundar.spring.eureka.customer.Entity.Customer;
import com.sundar.spring.eureka.customer.repository.CustomerRespository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRespository customerRepository;

	public List<Customer> getCustomer() {
		return customerRepository.findAll();
	}

	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

}
