package com.warehouse.warehouse.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class ItemCreateDto {
    @NotEmpty
    private String partNumber;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotEmpty
    private Integer placeId;
}
