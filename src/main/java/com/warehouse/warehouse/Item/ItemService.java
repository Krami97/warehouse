package com.warehouse.warehouse.Item;

import com.warehouse.warehouse.Item.dto.ItemCreateDto;
import com.warehouse.warehouse.Item.dto.ItemDetailsDto;
import com.warehouse.warehouse.Item.dto.ItemSummaryDto;
import com.warehouse.warehouse.photos.ItemPhoto;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ItemService {

    ItemSummaryDto create (ItemCreateDto dto);
    ItemSummaryDto patch(Integer itemId, Map<String,Object> updates) throws NoSuchFieldException;
    void delete(Integer itemId);
    ItemDetailsDto get(Integer itemId);
    List<ItemSummaryDto> getAll();
    Item findById(Integer itemId);
    Set<ItemPhoto> getPhotos(Integer itemId);



}
