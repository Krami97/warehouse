package com.warehouse.warehouse.Service;

import com.warehouse.warehouse.dto.PlaceCreateDto;
import com.warehouse.warehouse.entity.Place;


import java.util.List;
import java.util.Map;

public interface PlaceService {

    Place create(PlaceCreateDto dto);

    void delete(Integer id);

    List<Place> getAll();

    Place findById(Integer id);

    Place findByName(String name);

    Place patch(Integer id, Map<String,Object> updates);
}
