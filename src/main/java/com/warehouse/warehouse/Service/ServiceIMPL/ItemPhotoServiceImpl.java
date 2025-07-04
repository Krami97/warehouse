package com.warehouse.warehouse.Service.ServiceIMPL;

import com.warehouse.warehouse.Service.ItemPhotoService;
import com.warehouse.warehouse.Service.ItemService;
import com.warehouse.warehouse.dto.PhotoCreateDto;
import com.warehouse.warehouse.entity.Item;
import com.warehouse.warehouse.entity.ItemPhoto;
import com.warehouse.warehouse.repository.ItemPhotoRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemPhotoServiceImpl implements ItemPhotoService {
    @Autowired
    ItemPhotoRepo itemPhotoRepo;
    @Autowired
    ItemService itemService;


    @Override
    public ItemPhoto create(ItemPhoto photo,Integer itemId) {
        Item item = itemService.findById(itemId);
        photo.setItem(item);

        photo.setName(item.getName()); // set photo name same as item name

        return itemPhotoRepo.save(photo);
    }

    @Override
    public void delete(Integer id) {
        ItemPhoto itemPhoto = findById(id);
        itemPhotoRepo.delete(itemPhoto);
    }

    @Override
    public ItemPhoto findById(Integer id) {
        Optional<ItemPhoto> itemPhoto = itemPhotoRepo.findById(id);
        if(itemPhoto.isEmpty()){
            throw new EntityNotFoundException("No photo found");
        }
        return itemPhoto.get();
    }

    @Override
    public List<ItemPhoto> findAll() {
        return itemPhotoRepo.findAll();
    }
}
