package com.warehouse.warehouse.Service;

import com.warehouse.warehouse.dto.WarehouseCreateDto;
import com.warehouse.warehouse.entity.Warehouse;

import java.util.List;
import java.util.Map;

public interface WarehouseService {

    Warehouse create(WarehouseCreateDto dto);

    void delete(Integer id);

    List<Warehouse> get();

    Warehouse findById(Integer id);

    Warehouse findByName(String name);

    Warehouse patch(Integer id, Map<String,Object> updates);



}
