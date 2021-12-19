package com.salesianostriana.dam.TrianaTourist.dto.Route;

import com.salesianostriana.dam.TrianaTourist.model.PointOfInterest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class GetRouteDto {

    private Long id;
    private String name;
    private List<PointOfInterest> pointOfInterestList;
}
