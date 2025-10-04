package com.warehouse.warehouse.photos;

import com.warehouse.warehouse.Item.Item;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemPhoto extends Photo {


    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;


    public void setItem(@Nullable Item item){
        this.item = item;
        if(item!= null){
            item.addPhoto(this);
        }
    }
}
