package org.snyk.groceries.services;

import java.util.List;

import org.snyk.groceries.domain.Item;

public interface ItemService {
    public List<Item> getAllItems();
    
    public Item addItem(Item item);
    
    public void removeItem(Item item);
    
    public Item updateItem(Item item);
}