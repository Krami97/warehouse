package com.warehouse.warehouse.photos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemPhotoRepo extends JpaRepository<ItemPhoto,Integer> {
    @Query(value = "SELECT p FROM ItemPhoto WHERE p.item.id = :itemId")
    List<ItemPhoto> findAllItemPhotos(@Param("itemId") Integer itemId);

}
