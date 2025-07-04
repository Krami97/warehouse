package com.warehouse.warehouse.Service;

import com.warehouse.warehouse.dto.PhotoCreateDto;
import com.warehouse.warehouse.entity.ItemPhoto;

import java.util.List;

public interface ItemPhotoService {

    ItemPhoto create(ItemPhoto photo,Integer itemId);

    void delete(Integer id);

    ItemPhoto findById(Integer id);

    List<ItemPhoto> findAll();

}
