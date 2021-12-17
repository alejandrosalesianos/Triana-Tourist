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
    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "POI_id",
                    foreignKey = @ForeignKey(name = "FK_RUTA_POI")),
            inverseJoinColumns = @JoinColumn(name = "route_id",
                    foreignKey = @ForeignKey(name = "FK_RUTA_ROUTE")),
    name = "ruta")
    private List<Route> routes;

}
