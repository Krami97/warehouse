package com.warehouse.warehouse.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PhotoCreateDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String type;
    @NotEmpty
    private byte[] data;
    @NotEmpty
    private Integer itemId;



}
