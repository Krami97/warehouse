package com.warehouse.warehouse.Item;

import com.warehouse.warehouse.Position.Position;
import com.warehouse.warehouse.Warehouse.Warehouse;
import com.warehouse.warehouse.photos.ItemPhoto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;

    private String name;

    @Positive
    private Integer quantity;

    @Column(unique = true)
    private String partNumber;

    private String description;

    @OneToMany(mappedBy = "item",cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<ItemPhoto> itemPhotos = new HashSet<>();

    @OneToOne(mappedBy = "item",orphanRemoval = true,cascade = CascadeType.ALL)
    private Position position;

    @ManyToOne
    @JoinColumn(name="warehouse_id")
    private Warehouse warehouse;


    public void addPhoto(ItemPhoto photo){
        if(photo != null){
            this.itemPhotos.add(photo);

            if(!this.equals(photo.getItem())){
                photo.setItem(this);
            }
        }


    }

    public void removePhoto(ItemPhoto photo){
        if(photo != null){
            this.itemPhotos.remove(photo);
            if(this.equals(photo.getItem())){
                photo.setItem(null);
            }
        }
    }

    public void setWarehouse(Warehouse warehouse){
        if(warehouse != null){
            if(this.warehouse!= null && !this.warehouse.equals(warehouse)){
                this.warehouse.removeItem(this);
            }
            this.warehouse = warehouse;
            warehouse.addItem(this);

        }

    }

    public void setPosition(Position position){
        if(position != null){
            if(this.position != null && !this.position.equals(position)){
                this.position.setItem(null);
            }
            this.position=position;
            if(!this.equals(position.getItem())){
                position.setItem(this);
            }
        }

    }

}
