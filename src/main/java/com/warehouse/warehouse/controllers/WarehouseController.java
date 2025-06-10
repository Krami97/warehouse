package com.warehouse.warehouse.controllers;

import com.warehouse.warehouse.Service.WarehouseService;
import com.warehouse.warehouse.dto.WarehouseCreateDto;
import com.warehouse.warehouse.entity.Warehouse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController implements ControllerCRUD<Warehouse,Integer, WarehouseCreateDto>{

    @Autowired
    WarehouseService warehouseService;

    @Override
    @PostMapping
    public ResponseEntity<Warehouse> create(@Valid @RequestBody WarehouseCreateDto dto) {
        Warehouse warehouse = warehouseService.create(dto);
        URI location = URI.create("/warehouse/"+warehouse.getId());
        return ResponseEntity.created(location).body(warehouse);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Warehouse>> getAll() {
        List<Warehouse> warehouses = warehouseService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(warehouses);
    }

    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<Warehouse> patch(@PathVariable Integer id, @RequestBody Map<String,Object> updates) {
        Warehouse warehouse = warehouseService.patch(id,updates);
        return ResponseEntity.status(HttpStatus.OK).body(warehouse);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> get(@PathVariable Integer id) {
        Warehouse warehouse = warehouseService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(warehouse);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        warehouseService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
