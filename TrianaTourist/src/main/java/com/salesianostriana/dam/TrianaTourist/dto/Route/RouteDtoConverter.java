package com.salesianostriana.dam.TrianaTourist.dto.Route;

import com.salesianostriana.dam.TrianaTourist.model.Route;
import org.springframework.stereotype.Component;

@Component
public class RouteDtoConverter {

    public Route CreateRouteDtoToRoute (CreateRouteDto dto){
        return Route.builder()
                .name(dto.getName())
                .pointOfInterestList(dto.getPointOfInterestList())
                .build();
    }
    public GetRouteDto RouteToGetRouteDto (Route route){
        return GetRouteDto.builder()
                .id(route.getId())
                .name(route.getName())
                .pointOfInterestList(route.getPointOfInterestList())
                .build();
    }
}
