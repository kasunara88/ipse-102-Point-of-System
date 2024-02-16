package com.ijse.pos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.pos.dto.ItemDTO;
import com.ijse.pos.entity.Item;


@Service
public interface ItemService {
    List<Item> getAllItems();
    Item getItemById(Long itemId);
    Item createItem(ItemDTO item);
    Item updateItem (Long itemId , Item item);
    void deleteItem(Long itemId);
    List<Item> getItemsByCategory(Long id);
} 
