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
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "warehouse",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Set<Shelf> shelves;

    public void setShelf(Shelf shelf){
        shelves.add(shelf);
    }
}
