package com.sundar.spring.eureka.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sundar.spring.eureka.item.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
	Item findByName(String name);
}
