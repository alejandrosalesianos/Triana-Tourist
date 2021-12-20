package com.salesianostriana.dam.TrianaTourist.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PreRemove;
import java.io.Serializable;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
@Builder
public class Category implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    public void nullearCategoriaDePoi(List<PointOfInterest> pointOfInterestList){
        pointOfInterestList.forEach(poi -> poi.setCategory(null));
    }
}
