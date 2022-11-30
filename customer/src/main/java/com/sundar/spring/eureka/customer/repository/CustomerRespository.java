package com.sundar.spring.eureka.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sundar.spring.eureka.customer.Entity.Customer;

public interface CustomerRespository extends JpaRepository<Customer, Long> {

}
