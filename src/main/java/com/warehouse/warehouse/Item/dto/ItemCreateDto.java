package com.warehouse.warehouse.Item.dto;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class ItemCreateDto {
    @NotEmpty
    private String partNumber;
    @NotEmpty
    private String name;
    @NotEmpty
    private String itemDescription;
    @NotNull
    private Integer quantity;
    @NotEmpty
    private String positionDescription;
    @NotEmpty
    private String warehouseName;



}
