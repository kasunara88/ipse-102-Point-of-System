package com.ijse.pos.entity;

import java.time.LocalDateTime;
import java.util.HashSet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime orderTime;

    @Column(nullable = false)
    private double total;

    @Column(nullable = false)
    private double tax;

    @ManyToMany
    @JoinTable(
        name = "order_item",
        joinColumns = @JoinColumn(name= "order_id"),
        inverseJoinColumns = @JoinColumn(name = "item_id")

    )
    
    private java.util.Set<Item> items = new HashSet<>();
}
