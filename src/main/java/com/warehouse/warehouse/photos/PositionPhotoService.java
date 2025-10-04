package com.warehouse.warehouse.photos;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PositionPhotoService implements PhotoService<PositionPhoto> {

    @Autowired
    PositionPhotoRepo positionPhotoRepo;

    @Override
    public PositionPhoto create(PositionPhoto photo) {
        return positionPhotoRepo.save(photo);
    }

    @Override
    public void delete(Integer id) {
        PositionPhoto positionPhoto = findById(id);
        positionPhotoRepo.delete(positionPhoto);

    }

    @Override
    public PositionPhoto findById(Integer id) {
        Optional<PositionPhoto> optionalPositionPhoto = positionPhotoRepo.findById(id);
        if(optionalPositionPhoto.isEmpty()){
            throw new EntityNotFoundException("Photo not Found!");
        }
        return optionalPositionPhoto.get();
    }
}
