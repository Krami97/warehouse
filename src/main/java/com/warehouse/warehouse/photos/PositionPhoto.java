package com.warehouse.warehouse.photos;

import com.warehouse.warehouse.Position.Position;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PositionPhoto  extends Photo{



    @OneToOne
    @JoinColumn(name= "position_id")
    private Position position;


    public void setPosition(@Nullable Position position){
        this.position=position;
        if(position != null){
            position.setPositionPhoto(this);
        }

    }
}
