package com.ijse.pos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDTO {
    private String name;
    private String brand;
    private String unit;
    private Double price;
    //private Integer qty;
    private Long category_Id;
}
