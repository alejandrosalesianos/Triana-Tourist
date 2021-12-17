package com.salesianostriana.dam.TrianaTourist.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Setter @Getter
@Builder
public class Route implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
}
