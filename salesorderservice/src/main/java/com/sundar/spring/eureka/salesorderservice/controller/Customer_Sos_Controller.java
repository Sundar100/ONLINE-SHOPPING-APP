package com.sundar.spring.eureka.salesorderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sundar.spring.eureka.salesorderservice.entity.Customer_SOS;
import com.sundar.spring.eureka.salesorderservice.entity.InputRequest;
import com.sundar.spring.eureka.salesorderservice.entity.OutputResponse;
import com.sundar.spring.eureka.salesorderservice.service.Customer_Sos_Service;

@RestController
@RequestMapping("/sos")
public class Customer_Sos_Controller {
	@Autowired
	private Customer_Sos_Service customer_Sos_Service;

	

	@PostMapping("/subscribe")
	public void subscribeCustomer(@RequestBody Customer_SOS customersos) {
		customer_Sos_Service.subscribe(customersos);
	}

	@GetMapping("/get")
	public List<Customer_SOS> getCustomer() {
		return customer_Sos_Service.getall();
	}

	@PostMapping("/orders")
	public ResponseEntity<Object> placeOrders(@RequestBody InputRequest inputRequest) {
		ResponseEntity<Object> saved = customer_Sos_Service.placeOrder(inputRequest);
		return saved;
	}

	@GetMapping("/orders")
	public ResponseEntity<Object> getOrderDetailsByCustomerId(@RequestParam Long customerId) {
		return customer_Sos_Service.getOrderDetailsByCustomerId(customerId);
	}

	@GetMapping("/orders/{orderId}")
	public OutputResponse getOrderDetails(@PathVariable Long orderId) {
		return customer_Sos_Service.getOrderDetails(orderId);
	}

}
