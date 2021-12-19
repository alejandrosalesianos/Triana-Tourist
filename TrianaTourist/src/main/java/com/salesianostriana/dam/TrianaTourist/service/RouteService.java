package com.salesianostriana.dam.TrianaTourist.service;

import com.salesianostriana.dam.TrianaTourist.dto.Route.CreateRouteDto;
import com.salesianostriana.dam.TrianaTourist.dto.Route.GetRouteDto;
import com.salesianostriana.dam.TrianaTourist.dto.Route.RouteDtoConverter;
import com.salesianostriana.dam.TrianaTourist.error.excepciones.EntidadNotFoundException;
import com.salesianostriana.dam.TrianaTourist.error.excepciones.ListEntityNotFound;
import com.salesianostriana.dam.TrianaTourist.model.PointOfInterest;
import com.salesianostriana.dam.TrianaTourist.model.Route;
import com.salesianostriana.dam.TrianaTourist.repository.RouteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RouteService {

    private final RouteRepository routeRepository;
    private final RouteDtoConverter routeDtoConverter;

    public List<Route> findAll(){
        if (routeRepository.findAll().isEmpty()){
            throw new ListEntityNotFound(Route.class);
        }else{
            return routeRepository.findAll();
        }
    }
    public Optional<Route> findOne(Long id){
        if (routeRepository.findById(id).isEmpty()){
            throw new EntidadNotFoundException(id,Route.class);
        }else {
            return routeRepository.findById(id);
        }
    }
    public void deleteById(Long id){
        if (routeRepository.findById(id).isEmpty()){
            throw  new EntidadNotFoundException(id, Route.class);
        }else{
            routeRepository.deleteById(id);
        }
    }
    public Optional<GetRouteDto> edit (Long id, CreateRouteDto dto){
        return findOne(id).map(nuevo -> {
            nuevo.setName(dto.getName());
            nuevo.setPointOfInterestList(dto.getPointOfInterestList());
            save(nuevo);
            return routeDtoConverter.RouteToGetRouteDto(nuevo);
        });
    }

    public void save(Route route){
        routeRepository.save(route);
    }
}
