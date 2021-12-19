package com.salesianostriana.dam.TrianaTourist.controller;

import com.salesianostriana.dam.TrianaTourist.dto.PointOfInterest.GetPointOfInterestDto;
import com.salesianostriana.dam.TrianaTourist.dto.PointOfInterest.PointOfInterestDtoConverter;
import com.salesianostriana.dam.TrianaTourist.dto.Route.CreateRouteDto;
import com.salesianostriana.dam.TrianaTourist.dto.Route.GetRouteDto;
import com.salesianostriana.dam.TrianaTourist.dto.Route.RouteDtoConverter;
import com.salesianostriana.dam.TrianaTourist.model.PointOfInterest;
import com.salesianostriana.dam.TrianaTourist.model.Route;
import com.salesianostriana.dam.TrianaTourist.service.PointOfInterestService;
import com.salesianostriana.dam.TrianaTourist.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/route")
public class RouteController {

    private final RouteService routeService;
    private final RouteDtoConverter routeDtoConverter;
    private final PointOfInterestService pointOfInterestService;

    @GetMapping("/")
    public ResponseEntity<List<Route>> findAll(){
        return ResponseEntity.ok().body(routeService.findAll());
    }
    @PostMapping("/")
    public ResponseEntity<GetRouteDto> create(@Valid @RequestBody CreateRouteDto dto){
        Route route= routeDtoConverter.CreateRouteDtoToRoute(dto);
        routeService.save(route);
        return ResponseEntity.status(HttpStatus.CREATED).body(routeDtoConverter.RouteToGetRouteDto(route));
    }
    @PostMapping("/{id}/poi/{id2}")
    public ResponseEntity<GetRouteDto> addPoi(@Valid @PathVariable("id")Long id, @PathVariable("id2")Long id2){
        Route route = routeService.findOne(id).get();
        PointOfInterest poi= pointOfInterestService.findOne(id2).get();
        poi.addToRoute(route);
        pointOfInterestService.save(poi);
        return ResponseEntity.ok().body(routeDtoConverter.RouteToGetRouteDto(route));
    }
    @DeleteMapping("/{id}/poi/{id2}")
    public ResponseEntity<GetRouteDto> deletePoi(@Valid @PathVariable("id")Long id, @PathVariable("id2")Long id2){
        Route route = routeService.findOne(id).get();
        PointOfInterest poi= pointOfInterestService.findOne(id2).get();
        poi.deleteFromRoute(route);
        pointOfInterestService.save(poi);
        return ResponseEntity.ok().body(routeDtoConverter.RouteToGetRouteDto(route));
    }
}
