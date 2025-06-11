package com.warehouse.warehouse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String type;

    @Lob// saves photo
    private byte[] data;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;

    public ItemPhoto(String name ,String type,byte[] data){
        this.name= name;
        this.type=type;
        this.data=data;
    }


}
