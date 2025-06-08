package com.warehouse.warehouse.Service.ServiceIMPL;

import com.warehouse.warehouse.Service.ShelfService;
import com.warehouse.warehouse.Service.WarehouseService;
import com.warehouse.warehouse.dto.ShelfCreateDto;
import com.warehouse.warehouse.entity.Shelf;
import com.warehouse.warehouse.entity.Warehouse;
import com.warehouse.warehouse.repository.ShelfRepo;
import com.warehouse.warehouse.repository.WarehouseRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ShelfServiceImpl implements ShelfService {

    @Autowired
    ShelfRepo shelfRepo;

    @Autowired
    WarehouseService warehouseService;

    @Override
    public Shelf create(ShelfCreateDto dto) {
        Shelf shelf = new Shelf();
        shelf.setName(dto.getName());
        Warehouse warehouse = warehouseService.findById(dto.getWarehouseId());
        shelf.setWarehouse(warehouse);
        return shelfRepo.save(shelf);
    }

    @Override
    public void delete(Integer id) {
        Shelf shelf = findById(id);
        shelfRepo.delete(shelf);
    }

    @Override
    public List<Shelf> get() {
        return List.of();
    }

    @Override
    public Shelf findById(Integer id) {
        Optional<Shelf> shelf  = shelfRepo.findById(id);
        if(shelf.isEmpty()){
            throw new EntityNotFoundException("Shelf with that id dose not exist");
        }
        return shelf.get();
    }

    @Override
    public Shelf findByName(String name) {
        Optional<Shelf> shelf = shelfRepo.findByName(name);
        if(shelf.isEmpty()){
            throw new EntityNotFoundException("Shelf with that id dose not exist");
        }
        return shelf.get();
    }

    @Override
    public Shelf patch(Integer id, Map<String, Object> updates) {
        Shelf shelf = findById(id);
        for(Map.Entry<String,Object> entry : updates.entrySet()){
            try {
                Field field = Shelf.class.getField(entry.getKey());
                field.setAccessible(true);
                field.set(shelf,entry.getValue());
            } catch (IllegalAccessException |NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }
        return shelfRepo.save(shelf);
    }
}
