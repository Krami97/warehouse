package com.warehouse.warehouse.dto;

import jakarta.validation.constraints.NotEmpty;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlaceCreateDto {

    @NotEmpty
    private String name;
    @NotEmpty
    private Integer shelfId;
}
