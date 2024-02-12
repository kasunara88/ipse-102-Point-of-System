package com.ijse.pos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ijse.pos.dto.StockDTO;
import com.ijse.pos.entity.Stock;
import com.ijse.pos.service.ItemService;
import com.ijse.pos.service.StockService;

@RestController
@CrossOrigin(origins = "*")
public class StockController {

    @Autowired
    private StockService stockService;

    @Autowired ItemService itemService;

    @GetMapping("/stock")
    public ResponseEntity <List<Stock>> getAllStock(){
        return ResponseEntity.status(200).body(stockService.getAllStock());
    }
    
    @GetMapping("/stock/{stockId}")
    public ResponseEntity <Stock> getStockById(@PathVariable Long stockId){
        return ResponseEntity.status(200).body(stockService.getStockById(stockId));
    }

    @PostMapping("/stock")
    public ResponseEntity <Stock> addStock(@RequestBody StockDTO stockDTO){
        Stock stock = stockService.addStock(stockDTO);
        return ResponseEntity.status(201).body(stock);
    }

    @PutMapping("/stock/{stockId}")
    public ResponseEntity <Stock> updateStock(@PathVariable Long stockId, @RequestBody Stock stock){
        Stock updateStock = stockService.updateStock(stockId, stock);
        return ResponseEntity.ok().body(updateStock);
    }

    @DeleteMapping("/stock/{stockId}")
    public ResponseEntity<?> deleteStock(@PathVariable Long stockId){
        stockService.deleteStock(stockId);
        return ResponseEntity.ok().build();
    }
}
