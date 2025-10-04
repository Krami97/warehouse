package com.warehouse.warehouse.Warehouse;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WarehouseCreateDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String location;
    @NotEmpty
    private String description;
}
