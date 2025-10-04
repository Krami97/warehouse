package com.warehouse.warehouse.photos;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemPhotoService implements PhotoService<ItemPhoto> {
    @Autowired
    ItemPhotoRepo itemPhotoRepo;

    @Override
    public ItemPhoto create(ItemPhoto photo) {
        return itemPhotoRepo.save(photo);
    }

    @Override
    public void delete(Integer id) {
        ItemPhoto itemPhoto = findById(id);
        itemPhotoRepo.delete(itemPhoto);

    }

    @Override
    public ItemPhoto findById(Integer id) {
        Optional<ItemPhoto> itemPhotoOptional = itemPhotoRepo.findById(id);
        if(itemPhotoOptional.isEmpty()){
            throw new EntityNotFoundException("Photo not found!");
        }
        return itemPhotoOptional.get();
    }


    public List<ItemPhoto> findItemPhotos(Integer itemId){
        return itemPhotoRepo.findAllItemPhotos(itemId);

    }
}
