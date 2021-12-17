package com.salesianostriana.dam.TrianaTourist.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
@Builder
public class Category implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
}
