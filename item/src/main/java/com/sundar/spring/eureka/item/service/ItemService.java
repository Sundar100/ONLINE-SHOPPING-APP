package com.sundar.spring.eureka.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sundar.spring.eureka.item.entity.Item;
import com.sundar.spring.eureka.item.repository.ItemRepository;

@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;

	public List<Item> retrieveAll() {
		// TODO Auto-generated method stub
		return itemRepository.findAll();
	}

	public Item findByName(String name) {
		// TODO Auto-generated method stub
		return itemRepository.findByName(name);
	}

	public Item additem(Item item) {
		// TODO Auto-generated method stub
		return itemRepository.save(item);
	}

}
