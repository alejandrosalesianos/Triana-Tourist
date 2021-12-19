package com.salesianostriana.dam.TrianaTourist.service;

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

    public void save(Route route){
        routeRepository.save(route);
    }
}
