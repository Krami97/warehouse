package com.warehouse.warehouse.controllers;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ControllerCRUD<ResponseDTO, ID, CreateDTO> {


    ResponseEntity<ResponseDTO> create(CreateDTO dto);
    ResponseEntity<List<ResponseDTO>> getAll();
    ResponseEntity<ResponseDTO> patch(ID id, Map<String,Object> updates);
    ResponseEntity<ResponseDTO> get(ID id);
    ResponseEntity<Void> delete(ID id);
}
