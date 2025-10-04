package com.warehouse.warehouse.photos;

import com.warehouse.warehouse.Warehouse.WarehouseService;
import com.warehouse.warehouse.Warehouse.Warehouse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class WarehousePhotoService implements PhotoService<WarehousePhoto> {
    @Autowired
    WarehousePhotoRepo photoRepo;
    @Autowired
    WarehouseService warehouseService;


    @Override
    public WarehousePhoto create(MultipartFile multipartFile, Integer warehouseId) throws IOException {
        Warehouse warehouse =warehouseService.findById(warehouseId);
        WarehousePhoto warehousePhoto = new WarehousePhoto();
        warehousePhoto.setType(multipartFile.getContentType());
        warehousePhoto.setName(multipartFile.getName());
        warehousePhoto.setData(multipartFile.getBytes());
        warehousePhoto.setWarehouse(warehouse);
        return photoRepo.save(warehousePhoto);
    }

    @Override
    public void delete(Integer warehouseId) {
        Warehouse warehouse =  warehouseService.findById(warehouseId);
        WarehousePhoto warehousePhoto = warehouse.getWarehousePhoto();
        photoRepo.delete(warehousePhoto);
    }

    @Override
    public WarehousePhoto findById(Integer id) {
        Optional<WarehousePhoto> warehousePhoto = photoRepo.findById(id);
        if(warehousePhoto.isEmpty()){
            throw new EntityNotFoundException("Photo not found!");
        }
        return warehousePhoto.get();
    }
}
