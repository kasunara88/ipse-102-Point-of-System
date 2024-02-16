package com.ijse.pos.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ijse.pos.dto.StockDTO;
import com.ijse.pos.entity.Item;
import com.ijse.pos.entity.Stock;
import com.ijse.pos.repository.ItemRepository;
import com.ijse.pos.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService{

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemService itemService;

    @Override
    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }

    @Override
    public Stock getStockById(Long stockId) {
        return stockRepository.findById(stockId).orElse(null);
    }

    @Override
    public Stock addStock(StockDTO stockDTO) {
        
        Stock stock = new Stock();

        List<Long> items = stockDTO.getItems();

        Set<Item> itemSet = new HashSet<>();

        stock.setQuantityInStock(0);

        for(Long item : items){
            Item itemId = itemRepository.findById(item).orElse(null);
            if(itemId != null){
                itemSet.add(itemId);
                stock.setQuantityInStock(stock.getQuantityInStock() + itemId.getQty());
            }
        }

        stock.setItems(itemSet);
        return stockRepository.save(stock);

    }

    @Override
    public Stock updateStock(Long stockId, Stock stock) {
        validateStock(stock);
        Stock exsistingStock = getStockById(stockId);
        exsistingStock.setItems(stock.getItems());
        exsistingStock.setQuantityInStock(stock.getQuantityInStock());
        return stockRepository.save(exsistingStock);
        
    }

    @Override
    public void deleteStock(Long stockId) {
        stockRepository.deleteById(stockId);

    }
    
    public void validateStock(Stock stock) {
        // Check if items are provided
        if (stock.getItems() == null || stock.getItems().isEmpty()) {
            throw new IllegalArgumentException("At least one item must be provided for stock entry.");
        }

        // Check if all provided items exist
        for (Item item : stock.getItems()) {
            Item existingItem = itemService.getItemById(item.getItemId());
            if (existingItem == null) {
                throw new IllegalArgumentException("Item with ID " + item.getItemId() + " does not exist.");
            }
        }

        // Check if quantity in stock is non-negative
        if (stock.getQuantityInStock() == null || stock.getQuantityInStock() < 0) {
            throw new IllegalArgumentException("Quantity in stock must be a non-negative value.");
        }
    }
    
}
