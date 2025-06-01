package com.warehouse.warehouse.repository;

import com.warehouse.warehouse.entity.Shelf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelfRepo extends JpaRepository<Shelf,Integer> {
}
