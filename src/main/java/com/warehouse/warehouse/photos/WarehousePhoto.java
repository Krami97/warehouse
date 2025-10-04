package com.warehouse.warehouse.photos;

import com.warehouse.warehouse.Warehouse.Warehouse;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class WarehousePhoto extends Photo {

    @OneToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

    public void setWarehouse(@Nullable Warehouse warehouse){
        this.warehouse = warehouse;
        if(warehouse != null){
            warehouse.setPhoto(this);
        }

    }
}
