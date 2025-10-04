package com.warehouse.warehouse.Item;

import com.warehouse.warehouse.Item.dto.ItemCreateDto;
import com.warehouse.warehouse.Item.dto.ItemDetailsDto;
import com.warehouse.warehouse.Item.dto.ItemSummaryDto;
import com.warehouse.warehouse.Service.ItemService;
import com.warehouse.warehouse.controllers.ControllerCRUD;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    ItemServiceImpl itemService;


    @PostMapping
    public ResponseEntity<ItemSummaryDto> create(@Valid @RequestBody ItemCreateDto dto) {
        ItemSummaryDto item = itemService.create(dto);
        URI location = URI.create("/item/"+item.getId());
        return ResponseEntity.created(location).body(item);
    }


    @GetMapping
    public ResponseEntity<List<ItemSummaryDto>> getAll() {
        List<ItemSummaryDto> items = itemService.getAll();
        return ResponseEntity.ok(items);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<ItemSummaryDto> patch(@PathVariable Integer id, @RequestBody Map<String, Object> updates) {
        ItemSummaryDto item = itemService.patch(id,updates);
        return ResponseEntity.ok(item);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ItemDetailsDto> get(@PathVariable Integer id) {
        ItemDetailsDto item = itemService.get(id);
        return ResponseEntity.ok(item);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        itemService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
