package com.warehouse.warehouse.controllers;

import com.warehouse.warehouse.Service.PlaceService;
import com.warehouse.warehouse.dto.PlaceCreateDto;
import com.warehouse.warehouse.entity.Place;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/place")
public class PlaceController implements ControllerCRUD<Place,Integer, PlaceCreateDto>{
    @Autowired
    PlaceService placeService;

    @Override
    @PostMapping
    public ResponseEntity<Place> create(@RequestBody @Valid PlaceCreateDto dto) {
        Place place = placeService.create(dto);
        URI location = URI.create("/place/"+place.getId());
        return ResponseEntity.created(location).body(place);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Place>> getAll() {
        List<Place> places = placeService.getAll();
        return ResponseEntity.ok(places);
    }

    @Override
    @PatchMapping("/{id}")
    public ResponseEntity<Place> patch(@PathVariable Integer id, @RequestBody Map<String, Object> updates) {
        Place place = placeService.patch(id,updates);
        return ResponseEntity.ok(place);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Place> get(@PathVariable Integer id) {
        Place place = placeService.findById(id);
        return ResponseEntity.ok(place);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable  Integer id) {
        placeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
