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
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false,unique = true)
    private String name;


    @ManyToMany
    @JoinTable(
            name="place_item",
            joinColumns = @JoinColumn(name="place_id"),
            inverseJoinColumns = @JoinColumn(name="item_id")
    )
    private Set<Item> items;

    @ManyToOne(optional = false)
    @JoinColumn(name ="shelf_id")
    private Shelf shelf;
}
