package com.ijse.pos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ijse.pos.entity.Item;
import com.ijse.pos.entity.ItemCategory;

@Repository
public interface ItemRepository extends JpaRepository<Item,Long>{
    @Query("SELECT i FROM Item i WHERE i.category =:category")
    List<Item> findItemByCategory(@Param("category") ItemCategory category);
}
