package com.ijse.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.pos.entity.ItemCategory;
import com.ijse.pos.repository.ItemCategoryRepository;

@Service
public class ItemCategoryServiceImpl implements ItemCategoyService{

    @Autowired
    private ItemCategoryRepository itemCategoryRepository;

    @Override
    public List<ItemCategory> getAllItemCategories() {
        return itemCategoryRepository.findAll();
    }

    @Override
    public ItemCategory getCategoryById(Long categoryId) {
        return itemCategoryRepository.findById(categoryId).orElse(null);
    }

    // @Override
    // public ItemCategory creaItemCategory(ItemCategory category) {
    //    return itemCategoryRepository.save(category);
    // }

    @Override
    public ItemCategory updateItemCategory(Long categoryId, ItemCategory category) {
        ItemCategory exsistinCategory = itemCategoryRepository.findById(categoryId).orElse(null);

        if(exsistinCategory !=null){
            exsistinCategory.setCategoryName(category.getCategoryName());
            return itemCategoryRepository.save(exsistinCategory);
        }else{
            return null;
        }
    }

    @Override
    public void deleteCategory(Long categoryId) {
       ItemCategory category = itemCategoryRepository.findById(categoryId).orElse(null);
        itemCategoryRepository.delete(category);
       
    }

    @Override
    public ItemCategory createItemCategory(ItemCategory category) {
        return itemCategoryRepository.save(category);
    }
    
}
