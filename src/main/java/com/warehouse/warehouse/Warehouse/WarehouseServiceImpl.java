package com.warehouse.warehouse.Warehouse;

import com.warehouse.warehouse.photos.WarehousePhoto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    WarehouseRepo warehouseRepo;

    @Override
    public WarehouseSummaryDto create(WarehouseCreateDto dto) {
        Warehouse newWarehouse = new Warehouse();
        newWarehouse.setName(dto.getName());
        newWarehouse.setLocation(dto.getLocation());
        newWarehouse.setDescription(dto.getDescription());
        return new WarehouseSummaryDto(warehouseRepo.save(newWarehouse));
    }

    @Override
    public List<WarehouseSummaryDto> getAllWarehouseNames() {
        List<Warehouse> warehouses  = warehouseRepo.findAll();
        return warehouses.stream().map(warehouse -> new WarehouseSummaryDto(warehouse.getId(),warehouse.getName())).toList();
    }

    @Override
    public WarehouseSummaryDto patch(Map<String, Object> update, Integer warehouseId) {
        Warehouse oldWarehouse = findById(warehouseId);
        for(Map.Entry<String,Object> entry : update.entrySet()){
            try{
                Field field = Warehouse.class.getField(entry.getKey());
                field.setAccessible(true);
                field.set(oldWarehouse,entry.getValue());
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        Warehouse updatedWarehouse = warehouseRepo.save(oldWarehouse);
        return new WarehouseSummaryDto(updatedWarehouse);
    }

    @Override
    public void delete(Integer WarehouseId) {
        Warehouse warehouse = findById(WarehouseId);
        warehouseRepo.delete(warehouse);

    }

    @Override
    public Warehouse findById(Integer id) {
        Optional<Warehouse> warehouse = warehouseRepo.findById(id);
        if(warehouse.isEmpty()){
            throw new EntityNotFoundException("Warehouse not found!");
        }
        return warehouse.get();
    }

    @Override
    public WarehouseDetailsDto findDtoById(Integer id) {
        Warehouse warehouse = findById(id);
        return new WarehouseDetailsDto(warehouse);
    }

    @Override
    public Warehouse findByName(String warehouseName) {
        Optional<Warehouse> warehouse = warehouseRepo.findByName(warehouseName);
        if(warehouse.isEmpty()){
            throw new EntityNotFoundException("No warehouse with that name found.");
        }
        return warehouse.get();
    }

    @Override
    @Transactional
    public WarehousePhoto getPhoto(Integer warehouseId) {
        Warehouse warehouse  = findById(warehouseId);
        WarehousePhoto photo = warehouse.getWarehousePhoto();
        return photo;
    }
}
