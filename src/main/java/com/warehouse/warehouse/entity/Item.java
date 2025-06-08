package com.warehouse.warehouse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String partNumber;

    private String name;

    private String description;

    @OneToMany(mappedBy = "item",cascade = CascadeType.ALL)
    private Set<ItemPhoto> photos;

    @ManyToMany(mappedBy = "items")

    private Set<Place> places;

    public void setPlace(Place place){
        this.places.add(place);
    }

    public void setPhoto(ItemPhoto photo){
        this.photos.add(photo);
    }
}
