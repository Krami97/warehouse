package com.warehouse.warehouse.Warehouse;

import com.warehouse.warehouse.photos.WarehousePhotoService;

import com.warehouse.warehouse.photos.WarehousePhoto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {

    @Autowired
    WarehouseService warehouseService;
    @Autowired
    WarehousePhotoService warehousePhotoService;

    /**

     Creates a new warehouse.

     @param dto the warehouse creation data

     @return the created warehouse summary with location header */
    @PostMapping
    public ResponseEntity<WarehouseSummaryDto> create(@Valid @RequestBody WarehouseCreateDto dto) {
        WarehouseSummaryDto warehouse = warehouseService.create(dto);
        URI location = URI.create("/warehouse/"+warehouse.getId());
        return ResponseEntity.created(location).body(warehouse);
    }
    /**

     Uploads a photo for an existing warehouse.

     @param warehouseId the ID of the warehouse

     @param multipartFile the photo file

     @return success message with location header

     @throws IOException if file processing fails */
    @PostMapping("/photo/upload/{warehouseId}")
    public ResponseEntity<String> upload(@PathVariable Integer warehouseId ,@RequestParam("file")MultipartFile multipartFile) throws IOException {
        WarehousePhoto newPhoto = warehousePhotoService.create(multipartFile,warehouseId);
        URI location = URI.create("/warehouse/"+newPhoto.getWarehouse().getId());
        return ResponseEntity.created(location).body("Warehouse photo successfully uploaded");
    }

    /**

     Retrieves a list of all warehouses with minimal summary data.

     @return list of warehouse summaries */
    @GetMapping
    public ResponseEntity<List<WarehouseSummaryDto>> getAll() {
        List<WarehouseSummaryDto> warehouses = warehouseService.getAllWarehouseNames();
        return ResponseEntity.status(HttpStatus.OK).body(warehouses);
    }

    /**

     Partially updates a warehouse using a map of fields.

     @param id the warehouse ID

     @param updates the fields to update

     @return the updated warehouse summary */
    @PatchMapping("/{id}")
    public ResponseEntity<WarehouseSummaryDto> patch(@PathVariable Integer id, @RequestBody Map<String,Object> updates) {
        WarehouseSummaryDto warehouse = warehouseService.patch(updates,id);
        return ResponseEntity.status(HttpStatus.OK).body(warehouse);
    }

    /**

     Retrieves full details of a warehouse including its photo.

     @param id the warehouse ID

     @return the warehouse details */
    @GetMapping("/{id}")
    public ResponseEntity<WarehouseDetailsDto> get(@PathVariable Integer id) {
        WarehouseDetailsDto warehouse = warehouseService.findDtoById(id);
        return ResponseEntity.status(HttpStatus.OK).body(warehouse);
    }
    /**

     Deletes the photo associated with a warehouse.

     @param warehouseId the warehouse ID

     @return no content response */
    @DeleteMapping("/photo/{warehouseId}")
    public ResponseEntity<Void> removePhoto(@PathVariable Integer warehouseId){
        warehousePhotoService.delete(warehouseId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

    /**

     Deletes a warehouse by ID.

     @param id the warehouse ID

     @return no content response */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        warehouseService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/photo/{warehouseId}")
    public ResponseEntity<byte []> getPhoto(@PathVariable Integer warehouseId){
        WarehousePhoto warehousePhoto = warehouseService.getPhoto(warehouseId);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType(warehousePhoto.getType())).body(warehousePhoto.getData());
    }


}
