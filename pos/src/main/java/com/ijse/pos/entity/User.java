package com.ijse.pos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    // @Column(length = 40, nullable = false)
    // private String name;

    @Column(unique = true, length = 15)
    private String username;

    @Column (unique = true, length = 40)
    private String email;
    
    private String password;
}
