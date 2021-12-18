package com.salesianostriana.dam.TrianaTourist.service;

import com.salesianostriana.dam.TrianaTourist.error.excepciones.EntidadNotFoundException;
import com.salesianostriana.dam.TrianaTourist.error.excepciones.ListEntityNotFound;
import com.salesianostriana.dam.TrianaTourist.model.PointOfInterest;
import com.salesianostriana.dam.TrianaTourist.repository.PointOfInterestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PointOfInterestService {

    private final PointOfInterestRepository pointOfInterestRepository;

    public List<PointOfInterest> findAll(){
        if (pointOfInterestRepository.findAll().isEmpty()){
            throw new ListEntityNotFound(PointOfInterest.class);
        }else{
            return pointOfInterestRepository.findAll();
        }
    }
    public Optional<PointOfInterest> findOne(Long id){
        if (pointOfInterestRepository.findById(id).isEmpty()){
            throw new EntidadNotFoundException(id,PointOfInterest.class);
        }else {
            return pointOfInterestRepository.findById(id);
        }
    }
    public void deleteById(Long id){
        if (pointOfInterestRepository.findById(id).isEmpty()){
            throw new EntidadNotFoundException(id,PointOfInterest.class);
        }else{
            pointOfInterestRepository.deleteById(id);
        }
    }

    public void save (PointOfInterest pointOfInterest){
        pointOfInterestRepository.save(pointOfInterest);
    }
}
