package com.warehouse.warehouse.Service;

import com.warehouse.warehouse.dto.ShelfCreateDto;
import com.warehouse.warehouse.dto.WarehouseCreateDto;
import com.warehouse.warehouse.entity.Shelf;
import com.warehouse.warehouse.entity.Warehouse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface ShelfService {

    Shelf create(ShelfCreateDto dto);

    void delete(Integer id);

    List<Shelf> get();

    Shelf findById(Integer id);

    Shelf findByName(String name);

    Shelf patch(Integer id, Map<String,Object> updates);
}
