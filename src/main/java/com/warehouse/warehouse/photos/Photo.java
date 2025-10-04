package com.warehouse.warehouse.photos;

import jakarta.persistence.*;
import lombok.*;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String type;
    @Lob// saves photo
    private byte[] data;



    public Photo(String name , String type, byte[] data){
        this.name= name;
        this.type=type;
        this.data=data;
    }


}
