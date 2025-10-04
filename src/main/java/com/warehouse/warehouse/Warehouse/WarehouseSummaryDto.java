package com.warehouse.warehouse.Warehouse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class WarehouseSummaryDto {

    private Integer id;

    private String name;

    public WarehouseSummaryDto(Warehouse warehouse){
        this.id=warehouse.getId();
        this.name=warehouse.getName();
    }


}
