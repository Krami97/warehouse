package com.warehouse.warehouse.Service.ServiceIMPL;

import com.warehouse.warehouse.Service.WarehouseService;
import com.warehouse.warehouse.dto.WarehouseCreateDto;
import com.warehouse.warehouse.entity.Shelf;
import com.warehouse.warehouse.entity.Warehouse;
import com.warehouse.warehouse.repository.WarehouseRepo;
import jakarta.persistence.EntityNotFoundException;
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
    public Warehouse create(WarehouseCreateDto dto) {
        Warehouse newWarehouse = new Warehouse();
        newWarehouse.setName(dto.getName());
        return warehouseRepo.save(newWarehouse);
    }

    @Override
    public void delete(Integer id) {
        Warehouse warehouse = findById(id);
        warehouseRepo.delete(warehouse);
    }

    @Override
    public List<Warehouse> get() {
        return warehouseRepo.findAll();
    }

    @Override
    public Warehouse findById(Integer id) {
        Optional<Warehouse> warehouse = warehouseRepo.findById(id);

        if(warehouse.isEmpty()){
            throw new EntityNotFoundException("Warehouse with that id does not exist ");
        }
        return warehouse.get();
    }

    @Override
    public Warehouse findByName(String name) {
        Optional<Warehouse> warehouse = warehouseRepo.findByName(name);
        if(warehouse.isEmpty()){
            throw new EntityNotFoundException("Warehouse with that id does not exist ");
        }
        return warehouse.get();
    }

    @Override
    public Warehouse patch(Integer id, Map<String,Object> updates) {
        Warehouse warehouse = findById(id);

        for(Map.Entry<String,Object> entry : updates.entrySet()){
            try {
                Field field = Warehouse.class.getField(entry.getKey());
                field.setAccessible(true);
                field.set(warehouse,entry.getValue());
            }catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        return warehouseRepo.save(warehouse);
    }


}
