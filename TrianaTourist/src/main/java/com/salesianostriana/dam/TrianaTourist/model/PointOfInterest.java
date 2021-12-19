package com.salesianostriana.dam.TrianaTourist.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
@Builder
public class PointOfInterest implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String location;
    private String description;
    private LocalDateTime date;
    @ManyToOne
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "FK_POI_CATEGOPRY"))
    private Category category;
    private String coverPhoto;
    private String photo2;
    private String photo3;

    public void addToRoute(Route route){
        route.getPointOfInterestList().add(this);
    }
    public void deleteFromRoute(Route route){
        route.getPointOfInterestList().remove(this);
    }
}
