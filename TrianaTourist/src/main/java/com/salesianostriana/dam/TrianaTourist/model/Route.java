package com.salesianostriana.dam.TrianaTourist.model;

import com.salesianostriana.dam.TrianaTourist.validation.simple.UniqueName;
import com.salesianostriana.dam.TrianaTourist.validation.simple.UniquePoiInRoute;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
@Builder

public class Route implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "POI_id",
            foreignKey = @ForeignKey(name = "FK_RUTA_POI")),
            inverseJoinColumns = @JoinColumn(name = "route_id",
                    foreignKey = @ForeignKey(name = "FK_RUTA_ROUTE")),
            name = "ruta")
    @UniquePoiInRoute
    private List<PointOfInterest> pointOfInterestList;


}
