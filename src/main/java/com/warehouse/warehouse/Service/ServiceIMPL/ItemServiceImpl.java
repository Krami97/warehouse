package com.warehouse.warehouse.Service.ServiceIMPL;

import com.warehouse.warehouse.Service.ItemService;
import com.warehouse.warehouse.Service.PlaceService;
import com.warehouse.warehouse.dto.ItemCreateDto;
import com.warehouse.warehouse.entity.Item;
import com.warehouse.warehouse.entity.Place;
import com.warehouse.warehouse.repository.ItemRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepo itemRepo;
    @Autowired
    PlaceService placeService;
    @Override

    public Item create(ItemCreateDto dto) {
        Item newItem = new Item();
        Place place = placeService.findById(dto.getPlaceId());
        newItem.setPlace(place);
        newItem.setName(dto.getName());
        newItem.setDescription(dto.getDescription());
        newItem.setPartNumber(dto.getPartNumber());
        return itemRepo.save(newItem);
    }

    @Override
    public void delete(Integer id) {
        Item item = findById(id);
        itemRepo.delete(item);

    }

    @Override
    public List<Item> get() {
        return itemRepo.findAll();
    }

    @Override
    public Item findById(Integer id) {
        Optional<Item> item = itemRepo.findById(id);
        if(item.isEmpty()){
            throw new EntityNotFoundException("Item with that id dose not exist");
        }
        return item.get();
    }

    @Override
    public Item findByName(String name) {
        Optional<Item> item = itemRepo.findByName(name);
        if(item.isEmpty()){
            throw new EntityNotFoundException("Item with that name dose not exist");
        }
        return item.get();
    }

    @Override
    public Item patch(Integer id, Map<String, Object> updates) {
        Item item = findById(id);

        for(Map.Entry<String,Object> entry : updates.entrySet()){
            try{
                Field field = Item.class.getField(entry.getKey());
                field.setAccessible(true);
                field.set(item,entry.getValue());

            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return itemRepo.save(item);
    }
}
