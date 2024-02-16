package com.ijse.pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.pos.service.ItemCategoyService;

import io.swagger.v3.oas.annotations.tags.Tag;

import com.ijse.pos.entity.*;

@RestController
@CrossOrigin(origins = "*")
//@RequestMapping("/api/v1")
@Tag(name = "Item Category", description = " This API is used for CRUD operations on Item Category")
public class ItemCategoryController {

    @Autowired
    private ItemCategoyService categoryService;

    @GetMapping("/categories")
    public List<ItemCategory> getAllItemCategory() {
        return categoryService.getAllItemCategories();
    }

    @PostMapping("/categories")
    public ItemCategory createItemCategory(@RequestBody ItemCategory category) {
        return categoryService.createItemCategory(category);
    }

    @GetMapping("/categories/{categoryId}")
    public ItemCategory getCategoryId(@PathVariable Long categoryId) {
        return categoryService.getCategoryById(categoryId);
    }

    @PutMapping("/categories/{categoryId}")
    public ItemCategory updCategory(@PathVariable Long categoryId, @RequestBody ItemCategory category) {
        return categoryService.updateItemCategory(categoryId, category);
    }

    @DeleteMapping("/categories/{categoryId}")
    public void deleteCategory(@PathVariable Long categoryId) {
        categoryService.deleteCategory(categoryId);
    }

}
