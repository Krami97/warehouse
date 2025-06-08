package com.warehouse.warehouse.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlaceCreateDto {

    @NotEmpty
    String name;
    @NotEmpty
    Integer shelfId;
}
