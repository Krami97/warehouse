package com.warehouse.warehouse.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShelfCreateDto {

    @NotEmpty
    private String name;

    private Integer warehouseId;
}
