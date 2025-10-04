package com.warehouse.warehouse.Warehouse;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WarehouseDetailsDto {

    private Integer id;

    private String name;

    private String description;

    private String location;

    private String  photoUrl;

    public WarehouseDetailsDto(Warehouse warehouse){
        this.id =warehouse.getId();
        this.name = warehouse.getName();
        this.description = warehouse.getDescription();
        this.location = warehouse.getLocation();
        this.photoUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString() + "/warehouse/photo/"+warehouse.getId();
    }
}
