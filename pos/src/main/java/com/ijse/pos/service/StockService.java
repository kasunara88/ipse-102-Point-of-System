package com.ijse.pos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ijse.pos.dto.StockDTO;
import com.ijse.pos.entity.Stock;

@Service
public interface StockService {
    List<Stock> getAllStock();
    Stock getStockById(Long stockId);
    Stock addStock(StockDTO stockDTO);
    Stock updateStock(Long stockId, Stock stock);
    void deleteStock(Long stockId);




}
