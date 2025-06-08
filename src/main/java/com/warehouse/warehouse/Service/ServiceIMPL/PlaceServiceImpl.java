package com.warehouse.warehouse.Service.ServiceIMPL;

import com.warehouse.warehouse.Service.PlaceService;
import com.warehouse.warehouse.Service.ShelfService;
import com.warehouse.warehouse.dto.PlaceCreateDto;
import com.warehouse.warehouse.entity.Place;
import com.warehouse.warehouse.entity.Shelf;
import com.warehouse.warehouse.repository.PlaceRepo;
import com.warehouse.warehouse.repository.ShelfRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class PlaceServiceImpl implements PlaceService {

    @Autowired
    PlaceRepo placeRepo;
    @Autowired
    ShelfService shelfService;

    @Override
    public Place create(PlaceCreateDto dto) {
        Place place = new Place();
        Shelf shelf = shelfService.findById(dto.getShelfId());
        place.setName(dto.getName());
        place.setShelf(shelf);

        return placeRepo.save(place);
    }

    @Override
    public void delete(Integer id) {
        Place place =findById(id);
        placeRepo.delete(place);

    }

    @Override
    public List<Place> get() {
        return placeRepo.findAll();
    }

    @Override
    public Place findById(Integer id) {
        Optional<Place> place = placeRepo.findById(id);
        if(place.isEmpty()){
            throw new EntityNotFoundException("No place with that id exists");
        }
        return place.get();
    }

    @Override
    public Place findByName(String name) {
        Optional<Place> place = placeRepo.findByName(name);
        if(place.isEmpty()){
            throw new EntityNotFoundException("No place with that name exists");
        }
        return place.get();
    }

    @Override
    public Place patch(Integer id, Map<String, Object> updates) {
        Place place = findById(id);

        for(Map.Entry<String,Object> entry : updates.entrySet()){
            try{
                Field field = Place.class.getField(entry.getKey());
                field.setAccessible(true);
                field.set(place,entry.getValue());
            } catch (NoSuchFieldException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return placeRepo.save(place);
    }
}
