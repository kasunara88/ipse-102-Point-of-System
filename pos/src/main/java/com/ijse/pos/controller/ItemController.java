package com.ijse.pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.ijse.pos.dto.ItemDTO;
import com.ijse.pos.entity.Item;
import com.ijse.pos.service.ItemService;

@RestController
@CrossOrigin(origins = "*")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.getAllItems());
    }

    @PostMapping("/items")
    public ResponseEntity<?> createItem(@RequestBody ItemDTO itemDTO) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(itemService.createItem(itemDTO));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Faill to Create the Item");
            
        }
    }

    @GetMapping("/items/{id}")
    public ResponseEntity <Item> getItemById(@PathVariable Long itemId){
        Item item = itemService.getItemById(itemId);
        if(item != null){
            return ResponseEntity.status(HttpStatus.OK).body(item);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

        @PutMapping("/items/{id}")
        public Item updateItem(@PathVariable Long itemId, @RequestBody Item item){
            return itemService.updateItem(itemId, item);
        }

        @GetMapping("/items/{id}/category")
        public ResponseEntity <List<Item>> getItemByCategory(@PathVariable Long categoryId){
            return ResponseEntity.ok().body(itemService.getItemsByCategory(categoryId));
        }

        @DeleteMapping("/items/{id}")
        public ResponseEntity<?> deleteItem(@PathVariable Long itemId){
            itemService.deleteItem(itemId);
            return ResponseEntity.ok().build();
        }

    }


