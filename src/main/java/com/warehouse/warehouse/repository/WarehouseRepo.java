package com.warehouse.warehouse.repository;

import com.warehouse.warehouse.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WarehouseRepo extends JpaRepository<Warehouse,Integer> {

    Optional<Warehouse> findByName(String name);
}
