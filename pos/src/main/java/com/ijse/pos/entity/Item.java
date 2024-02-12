package com.ijse.pos.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;
    private String name;
    private Double price;
    private Integer qty;

    @ManyToOne
    @JoinColumn(name = "category_Id")
    private ItemCategory category;


    // @JsonIgnore
    // @OneToMany(fetch = FetchType.LAZY,mappedBy = "item", cascade = CascadeType.ALL)
    // private List<Stock> stock;

}
