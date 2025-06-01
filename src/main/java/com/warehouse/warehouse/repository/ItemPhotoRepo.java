package com.warehouse.warehouse.repository;

import com.warehouse.warehouse.entity.ItemPhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPhotoRepo extends JpaRepository<ItemPhoto,Integer> {
}
