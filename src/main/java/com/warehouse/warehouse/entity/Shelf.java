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
public class Shelf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true,nullable = false)
    private String name;
    @OneToMany(mappedBy = "shelf",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Place> places;

    @ManyToOne(optional = false)
    @JoinColumn(name= "warehouse_id")
    private Warehouse warehouse;

    public void  setPlace(Place place){
        this.places.add(place);
    }
}
