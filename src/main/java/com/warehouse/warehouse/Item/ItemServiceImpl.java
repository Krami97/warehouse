package com.warehouse.warehouse.Item;

import com.warehouse.warehouse.Item.dto.ItemCreateDto;
import com.warehouse.warehouse.Item.dto.ItemDetailsDto;
import com.warehouse.warehouse.Item.dto.ItemSummaryDto;
import com.warehouse.warehouse.Position.Position;
import com.warehouse.warehouse.Warehouse.Warehouse;
import com.warehouse.warehouse.Warehouse.WarehouseService;
import com.warehouse.warehouse.photos.ItemPhoto;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class ItemServiceImpl implements ItemService{
    @Autowired
    ItemRepo itemRepo;
    @Autowired
    WarehouseService warehouseService;
    @Override
    public ItemSummaryDto create(ItemCreateDto dto) {
        Warehouse warehouse = warehouseService.findByName(dto.getWarehouseName());
        Position position = new Position();
        position.setDescription(dto.getPositionDescription());
        Item item = new Item();
        item.setPosition(position);
        item.setName(dto.getName());
        item.setQuantity(dto.getQuantity());
        item.setPartNumber(dto.getPartNumber());
        item.setWarehouse(warehouse);
        Item newItem = itemRepo.save(item);
        return new ItemSummaryDto(newItem.getId(),newItem.getPartNumber(),newItem.getName(),newItem.getDescription(),position.getDescription(),warehouse.getName());
    }

    @Override
    public ItemSummaryDto patch(Integer itemId, Map<String, Object> updates)  {
        Item oldItem = findById(itemId);
        try {
            for (Map.Entry<String, Object> entry : updates.entrySet()) {
                Field field = Item.class.getField(entry.getKey());
                field.setAccessible(true);
                field.set(oldItem,entry.getValue());
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        Item updatedItem = itemRepo.save(oldItem);
        return new ItemSummaryDto(updatedItem.getId(),updatedItem.getPartNumber(),updatedItem.getName(),updatedItem.getDescription(),updatedItem.getPosition().getDescription(),updatedItem.getWarehouse().getName());
    }

    @Override
    public void delete(Integer itemId) {
        Item item =findById(itemId);
        itemRepo.delete(item);
    }

    @Override
    @Transactional
    public ItemDetailsDto get(Integer itemId) {
        Item item = findById(itemId);
        ItemDetailsDto itemDetailsDto = new ItemDetailsDto();
        itemDetailsDto.setItemPhotos(item.getItemPhotos());
        itemDetailsDto.setId(item.getId());
        itemDetailsDto.setQuantity(item.getQuantity());
        itemDetailsDto.setPartNumber(item.getPartNumber());
        itemDetailsDto.setDescription(item.getDescription());
        itemDetailsDto.setWarehouseName(item.getWarehouse().getName());
        itemDetailsDto.setPositionDescription(item.getPosition().getDescription());
        itemDetailsDto.setName(item.getName());
        return itemDetailsDto;
    }

    @Override
    public List<ItemSummaryDto> getAll() {
        List<Item> items = itemRepo.findAll();
        List<ItemSummaryDto> summaryLIst= items.stream().map(item -> new ItemSummaryDto(item.getId(),item.getPartNumber(),item.getName(),item.getDescription(),item.getPosition().getDescription(),item.getWarehouse().getName())).toList();
        return summaryLIst;
    }

    @Override
    public Item findById(Integer id) {
        Optional<Item> item = itemRepo.findById(id);
        if(item.isEmpty()){
            throw new EntityNotFoundException("Item not found.");
        }
        return item.get();
    }

    @Override
    @Transactional
    public Set<ItemPhoto> getPhotos(Integer itemId) {
        Item item = findById(itemId);
        return item.getItemPhotos();
    }
}
