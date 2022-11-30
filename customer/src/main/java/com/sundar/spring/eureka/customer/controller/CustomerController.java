package com.sundar.spring.eureka.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.sundar.spring.eureka.customer.Entity.Customer;
import com.sundar.spring.eureka.customer.service.CustomerService;
import com.sundar.spring.eureka.customer.sos.Entity.Customer_SOS;

@RestController
@RequestMapping("/customer-service")
@RefreshScope
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	@Lazy
	private RestTemplate template;

	@Value("${microservices.sos-service.endpoints.endpoint.uri}")
	private String ENDPOINT_URI;

	@GetMapping("/customers")
	public List<Customer> getCustomer() {
		return customerService.getCustomer();
	}

	@PostMapping("/customer")
	public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) {

		Customer saved = customerService.addCustomer(customer);
		Customer_SOS customer_SOS = new Customer_SOS(saved.getId(), saved.getFirst_name(), saved.getLast_name(),
				saved.getEmail());

		System.out.println(customer_SOS.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Authorization", "Basic c3VuZGFyOmRldmVsb3Blcg==");

		HttpEntity<Object> requestEntity = new HttpEntity<>(customer_SOS, headers);
		ResponseEntity<Customer_SOS> response = template.exchange(ENDPOINT_URI, HttpMethod.POST, requestEntity,
				Customer_SOS.class);

//		Customer_SOS savedSos = template.postForObject("http://localhost:8083/subscribe", customer_SOS, Customer_SOS.class);
		return new ResponseEntity<Object>(saved, HttpStatus.CREATED);
	}

}
