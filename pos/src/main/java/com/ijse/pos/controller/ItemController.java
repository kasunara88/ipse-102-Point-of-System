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

import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@CrossOrigin(origins = "*")
@Tag(name = "Item Management", description = " This API is used for Item Management")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems() {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.getAllItems());
    }

    @PostMapping("/items")
    public ResponseEntity<?> createItem(@RequestBody ItemDTO items) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(itemService.createItem(items));

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Faill to Create the Item");
            
        }
    }

    @GetMapping("/items/{itemId}")
    public ResponseEntity <Item> getItemById(@PathVariable Long itemId){
        Item item = itemService.getItemById(itemId);
        if(item != null){
            return ResponseEntity.status(HttpStatus.OK).body(item);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

        @PutMapping("/items/{itemId}")
        public Item updateItem(@PathVariable Long itemId, @RequestBody Item items){
            return itemService.updateItem(itemId, items);
        }

        @GetMapping("/categories/{categoryId}/items")
        public ResponseEntity <List<Item>> getItemByCategory(@PathVariable Long categoryId){
            return ResponseEntity.ok().body(itemService.getItemsByCategory(categoryId));
        }

        @DeleteMapping("/items/{itemId}")
        public ResponseEntity<?> deleteItem(@PathVariable Long itemId){
            itemService.deleteItem(itemId);
            return ResponseEntity.ok().build();
        }

    }


