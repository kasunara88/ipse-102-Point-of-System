package com.ijse.pos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.pos.entity.ItemCategory;

@Service
public interface ItemCategoyService {
    List<ItemCategory> getAllItemCategories();
    ItemCategory getCategoryById(Long categoryId);
    ItemCategory createItemCategory(ItemCategory category);
    ItemCategory updateItemCategory(Long categoryId, ItemCategory category);
    void deleteCategory(Long categoryId);

}
