package com.salesianostriana.dam.TrianaTourist.dto.PointOfInterest;

import com.salesianostriana.dam.TrianaTourist.model.Category;
import com.salesianostriana.dam.TrianaTourist.model.Route;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor @AllArgsConstructor
@Builder
public class GetPointOfInterestDto {

    private Long id;
    private String name;
    private String location;
    private String description;
    private LocalDateTime date;
    private Category category;
    private String coverPhoto;
    private String photo2;
    private String photo3;
    private List<Route> routes;
}
