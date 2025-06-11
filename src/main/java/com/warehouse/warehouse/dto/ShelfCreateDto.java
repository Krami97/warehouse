package com.warehouse.warehouse.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShelfCreateDto {

    @NotEmpty
    private String name;
    @NotNull
    private Integer warehouseId;
}
