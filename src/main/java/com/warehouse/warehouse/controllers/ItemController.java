package com.warehouse.warehouse.controllers;

import com.warehouse.warehouse.Service.ItemService;
import com.warehouse.warehouse.dto.ItemCreateDto;
import com.warehouse.warehouse.entity.Item;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/item")
public class ItemController implements ControllerCRUD<Item,Integer, ItemCreateDto>{
    @Autowired
    ItemService itemService;

    @Override
    @PostMapping
    public ResponseEntity<Item> create(@Valid @RequestBody ItemCreateDto dto) {
        Item item = itemService.create(dto);
        URI location = URI.create("/item/"+item.getId());
        return ResponseEntity.created(location).body(item);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Item>> getAll() {
        List<Item> items = itemService.getAll();
        return ResponseEntity.ok(items);
    }

    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<Item> patch(@PathVariable Integer id, @RequestBody Map<String, Object> updates) {
        Item item = itemService.patch(id,updates);
        return ResponseEntity.ok(item);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Item> get(@PathVariable Integer id) {
        Item item = itemService.findById(id);
        return ResponseEntity.ok(item);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        itemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
