package com.salesianostriana.dam.TrianaTourist.dto.Route;

import com.salesianostriana.dam.TrianaTourist.model.PointOfInterest;
import com.salesianostriana.dam.TrianaTourist.validation.simple.UniqueName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor
public class CreateRouteDto {

    @NotBlank
    @UniqueName
    private String name;

    private List<PointOfInterest> pointOfInterestList;
}
