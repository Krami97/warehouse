package com.warehouse.warehouse.Service;

import com.warehouse.warehouse.dto.ItemCreateDto;
import com.warehouse.warehouse.dto.PlaceCreateDto;
import com.warehouse.warehouse.entity.Item;
import com.warehouse.warehouse.entity.Place;

import java.util.List;
import java.util.Map;

public interface ItemService {


    Item create(ItemCreateDto dto);

    void delete(Integer id);

    List<Item> get();

    Item findById(Integer id);

    Item findByName(String name);

    Item patch(Integer id, Map<String,Object> updates);


}
