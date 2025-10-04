package com.warehouse.warehouse.Item.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ItemSummaryDto {

    private Integer id;

    private String partNumber;

    private String name;

    private String description;

    private String positionDescription;

    private String warehouseName;

}
