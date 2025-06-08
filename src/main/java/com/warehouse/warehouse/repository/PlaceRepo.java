package com.warehouse.warehouse.repository;

import com.warehouse.warehouse.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlaceRepo extends JpaRepository<Place,Integer> {
    Optional<Place> findByName(String name);
}
