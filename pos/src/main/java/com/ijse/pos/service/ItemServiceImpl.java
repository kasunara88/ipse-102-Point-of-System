package com.ijse.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.pos.dto.ItemDTO;
import com.ijse.pos.entity.Item;
import com.ijse.pos.entity.ItemCategory;
import com.ijse.pos.repository.ItemCategoryRepository;
import com.ijse.pos.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(Long itemId) {
        return itemRepository.findById(itemId).orElse(null);
    }

    @Override
    public Item createItem(ItemDTO itemDTO) {
        ItemCategory category = itemCategoryRepository.findById(itemDTO.getCategory_Id()).orElse(null);

        if(category !=null){
            Item item = new Item();
            item.setName(itemDTO.getName());
            item.setBrand(itemDTO.getBrand());
            item.setUnit(itemDTO.getUnit());
            item.setPrice(itemDTO.getPrice());
           // item.setQty(itemDTO.getQty());
            item.setCategory(category);

            return itemRepository.save(item);
        }else{
            return null;
        }
        
    }

    @Override
    public Item updateItem(Long itemId, Item item) {
        Item exsistingItem = itemRepository.findById(itemId).orElse(null); 

        if(exsistingItem !=null){
            exsistingItem.setName(item.getName());
            exsistingItem.setBrand(item.getBrand());
            exsistingItem.setUnit(item.getUnit());
            exsistingItem.setQty(item.getQty());
            exsistingItem.setPrice(item.getPrice());
            exsistingItem.setCategory(item.getCategory());
            
            return itemRepository.save(exsistingItem);
        }else{
            return null;
        }
    }

    @Override
    public void deleteItem(Long itemId) {
        Item item = itemRepository.findById(itemId).orElse(null);
            itemRepository.delete(item);
    }

    @Override
    public List<Item> getItemsByCategory(Long id) {
        ItemCategory category = itemCategoryRepository.findById(id).orElse(null);
        if(category !=null){
            return itemRepository.findItemByCategory(category);
        }else{
            return null;
        }
    }
    
}
