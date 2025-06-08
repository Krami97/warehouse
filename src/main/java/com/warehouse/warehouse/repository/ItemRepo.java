package com.warehouse.warehouse.repository;

import com.warehouse.warehouse.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepo extends JpaRepository<Item,Integer> {
    Optional<Item> findByName(String name);
}
