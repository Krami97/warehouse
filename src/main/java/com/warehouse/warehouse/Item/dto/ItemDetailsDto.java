package com.warehouse.warehouse.Item.dto;

import com.warehouse.warehouse.Item.Item;
import com.warehouse.warehouse.photos.ItemPhoto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemDetailsDto {

    private Integer id;

    private String name;


    private Integer quantity;


    private String partNumber;

    private String description;


    private String itemPhotosUrl;

    private String warehouseName;

    private String positionDescription;


    public ItemDetailsDto(Item item){
        this.id=item.getId();
        this.name=item.getName();
        this.quantity=item.getQuantity();
        this.partNumber=item.getPartNumber();
        this.description=item.getDescription();
        this.warehouseName = item.getWarehouse().getName();
        this.positionDescription = item.getPosition().getDescription();
        this.itemPhotosUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString()+"/item/photo/"+item.getId();
    }
}
