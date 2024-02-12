package com.ijse.pos.entity;

import java.util.HashSet;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
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
    private String brand; // Brand of the item
    private String unit; // Unit of measurement (e.g., "kg", "pieces")
    private Integer qty;
    private Double price;
    
    @ManyToOne
    @JoinColumn(name = "category_Id")
    private ItemCategory category;

    @JsonIgnore
    @ManyToMany(mappedBy = "items")
    private Set<Stock> stock = new HashSet<>();


    // @JsonIgnore
    // @OneToMany(fetch = FetchType.LAZY,mappedBy = "item", cascade = CascadeType.ALL)
    // private List<Stock> stock;

}
