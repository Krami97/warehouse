package com.warehouse.warehouse.controllers;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ControllerCRUD<T, ID, DTO> {


    ResponseEntity<T> create(DTO dto);
    ResponseEntity<List<T>> getAll();
    ResponseEntity<T> patch(ID id, Map<String,Object> updates);
    ResponseEntity<T> get(ID id);
    ResponseEntity<Void> delete(ID id);
}
