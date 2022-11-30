package com.sundar.spring.eureka.salesorderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sundar.spring.eureka.salesorderservice.entity.Order_Line_Item;

public interface Order_Line_Item_Repository extends JpaRepository<Order_Line_Item, Long> {

	@Query("SELECT so FROM Order_Line_Item so WHERE so.order_id = :order_id")
	List<Order_Line_Item> findByOrderId(@Param("order_id") Long order_id);
}
