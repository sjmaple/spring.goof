package org.snyk.groceries.controller;

import java.util.List;

import org.snyk.groceries.domain.Item;
import org.snyk.groceries.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;

@Component
public class ItemAction extends ActionSupport {

   private List<Item> items;
    
   @Autowired
   private ItemService itemService;
    
   public String execute() throws Exception {
       items = (List<Item>) itemService.getAllItems();
       return SUCCESS;
   }

   public List<Item> getItems(){
       return items;
   }
}