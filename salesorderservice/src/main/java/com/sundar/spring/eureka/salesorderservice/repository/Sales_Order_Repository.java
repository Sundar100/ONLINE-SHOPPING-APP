package com.sundar.spring.eureka.salesorderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sundar.spring.eureka.salesorderservice.entity.Sales_Order;

public interface Sales_Order_Repository extends JpaRepository<Sales_Order, Long> {

	@Query("SELECT so FROM Sales_Order so WHERE so.cust_id = :cust_id")
	List<Sales_Order> findOrderByCustomerId(@Param("cust_id") Long cust_id);

	@Query("SELECT so FROM Sales_Order so WHERE so.id = :id")
	Sales_Order findOrderById(@Param("id") Long id);

}
