package com.warehouse.warehouse.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String partNumber;

    private String name;

    private String description;

    @OneToMany(mappedBy = "item",cascade = CascadeType.ALL)
    private Set<ItemPhoto> photos;

    @ManyToMany(mappedBy = "items")
    private Set<Place> places;
}
