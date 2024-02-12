package com.ijse.pos.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockDTO {
    private List<Long> items; 
    private Integer qtyInStock;
    //private boolean available;
    //private boolean onSale;
}
