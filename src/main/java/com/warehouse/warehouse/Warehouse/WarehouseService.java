package com.warehouse.warehouse.Warehouse;

import com.warehouse.warehouse.photos.WarehousePhoto;

import java.util.List;
import java.util.Map;

public interface WarehouseService {

    WarehouseSummaryDto create(WarehouseCreateDto dto);
    List<WarehouseSummaryDto> getAllWarehouseNames();
    WarehouseSummaryDto patch(Map<String,Object> update, Integer warehouseId);
    void delete(Integer WarehouseId);
    Warehouse findById(Integer id);
    WarehouseDetailsDto findDtoById(Integer warehouseId);
    Warehouse findByName(String warehouseName);
    WarehousePhoto getPhoto(Integer warehouseId);


    


}
