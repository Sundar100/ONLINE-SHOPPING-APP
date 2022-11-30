package com.sundar.spring.eureka.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sundar.spring.eureka.item.entity.Item;
import com.sundar.spring.eureka.item.service.ItemService;

@RestController
@RequestMapping("/item-service")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@GetMapping("/items")
	public List<Item> retrieveAll() {
		return itemService.retrieveAll();
	}

	@PostMapping("/items")
	public ResponseEntity<Item> add(@RequestBody Item item) {
		Item saved = itemService.additem(item);
		return new ResponseEntity<Item>(saved, HttpStatus.CREATED);
	}

	@GetMapping("/items/{itemname}")
	public Item findByName(@PathVariable String itemname) {
		return itemService.findByName(itemname);
	}
}
