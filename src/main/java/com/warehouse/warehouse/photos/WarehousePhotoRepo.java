package com.warehouse.warehouse.photos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WarehousePhotoRepo extends JpaRepository<WarehousePhoto,Integer> {
}
