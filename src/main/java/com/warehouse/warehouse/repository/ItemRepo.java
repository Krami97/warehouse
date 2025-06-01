package com.warehouse.warehouse.repository;

import com.warehouse.warehouse.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item,Integer> {
}
