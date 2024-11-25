package com.beridjalan.warehouse.repository;

import com.beridjalan.warehouse.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("SELECT i FROM Item i WHERE i.deletedAt IS NULL")
    List<Item> findActiveItems();
}
