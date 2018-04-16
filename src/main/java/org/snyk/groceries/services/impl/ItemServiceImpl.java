package org.snyk.groceries.services.impl;

import java.util.List;

import org.snyk.groceries.domain.Item;
import org.snyk.groceries.repository.ItemRepository;
import org.snyk.groceries.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemRepository itemRepo;
	
	@Override
	public List<Item> getAllItems() {
		return itemRepo.findAll();
	}

	@Override
	public Item addItem(Item item) {
		return itemRepo.save(item);
	}

	@Override
	public void removeItem(Item item) {
		itemRepo.delete(item);
	}

	@Override
	public Item updateItem(Item item) {
		return itemRepo.save(item);
	}

}
