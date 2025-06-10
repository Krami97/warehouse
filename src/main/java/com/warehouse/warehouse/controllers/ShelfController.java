package com.warehouse.warehouse.controllers;

import com.warehouse.warehouse.Service.ShelfService;
import com.warehouse.warehouse.dto.ShelfCreateDto;
import com.warehouse.warehouse.entity.Shelf;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/shelf")
public class ShelfController implements ControllerCRUD<Shelf,Integer, ShelfCreateDto>{
    @Autowired
    ShelfService shelfService;

    @Override
    @PostMapping
    public ResponseEntity<Shelf> create(@RequestBody @Valid ShelfCreateDto dto) {
        Shelf shelf = shelfService.create(dto);
        URI location = URI.create("/shelf/"+shelf.getId());
        return ResponseEntity.created(location).body(shelf);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Shelf>> getAll() {
        List<Shelf> shelves = shelfService.getAll();
        return ResponseEntity.ok(shelves);
    }

    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<Shelf> patch(@PathVariable Integer id,@RequestBody Map<String, Object> updates) {
        Shelf shelf = shelfService.patch(id,updates);
        return ResponseEntity.ok(shelf);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Shelf> get(@PathVariable Integer id) {
        Shelf shelf = shelfService.findById(id);
        return ResponseEntity.ok(shelf);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        shelfService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
