package com.warehouse.warehouse.Warehouse;

import com.warehouse.warehouse.Item.Item;
import com.warehouse.warehouse.photos.WarehousePhoto;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    @Column(unique = true)
    private String name;

    private String description;

    private String location;

    @OneToMany(mappedBy = "warehouse",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Item> items = new HashSet<>();;

    @OneToOne(mappedBy = "warehouse",cascade = CascadeType.ALL,orphanRemoval = true)
    private WarehousePhoto warehousePhoto;


    public void addItem(Item item){
        if(item != null){
            items.add(item);
            if(!this.equals(item.getWarehouse())){
                item.setWarehouse(this);
            }
        }

    }

    public void removeItem(Item item){
        if(item != null){
            if(this.items.contains(item)){
                items.remove(item);
            }
            if(this.equals(item.getWarehouse()) ){
                item.setWarehouse(null);
            }

        }

    }
    public void setPhoto( WarehousePhoto warehousePhoto){
        if(this.warehousePhoto!= null && !this.warehousePhoto.equals(warehousePhoto)){
            this.warehousePhoto.setWarehouse(null);
        }
        if(warehousePhoto!= null && !warehousePhoto.equals(this.warehousePhoto)){
            this.warehousePhoto = warehousePhoto;

        }

    }
    public void removePhoto(){
        if(this.warehousePhoto != null && this.warehousePhoto.getWarehouse().equals(this)){
            this.warehousePhoto.setWarehouse(null);
        }
        this.warehousePhoto = null;

    }

}
