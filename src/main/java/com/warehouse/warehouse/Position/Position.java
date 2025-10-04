package com.warehouse.warehouse.Position;

import com.warehouse.warehouse.Item.Item;
import com.warehouse.warehouse.photos.PositionPhoto;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    private String description;

    @OneToOne
    @JoinColumn(name = "item_id")
    private Item item;


    @OneToOne(mappedBy = "position",cascade = CascadeType.ALL,orphanRemoval = true)
    private PositionPhoto positionPhoto;

    public void setPositionPhoto(PositionPhoto photo){
        if(this.positionPhoto != null && !this.positionPhoto.equals(photo)){
            this.positionPhoto.setPosition(null);
        }
        this.positionPhoto = photo;
        if(photo != null && !this.equals(photo.getPosition())){

            photo.setPosition(this);
        }
    }

    public void setItem(Item item){
        this.item = item;
        if(item!= null && !this.equals(item.getPosition())){
            item.setPosition(this);
        }
    }

}
