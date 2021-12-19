package com.salesianostriana.dam.TrianaTourist.controller;

import com.salesianostriana.dam.TrianaTourist.dto.PointOfInterest.CreatePointOfInterestDto;
import com.salesianostriana.dam.TrianaTourist.dto.PointOfInterest.GetPointOfInterestDto;
import com.salesianostriana.dam.TrianaTourist.dto.PointOfInterest.PointOfInterestDtoConverter;
import com.salesianostriana.dam.TrianaTourist.model.PointOfInterest;
import com.salesianostriana.dam.TrianaTourist.service.CategoryService;
import com.salesianostriana.dam.TrianaTourist.service.PointOfInterestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/poi")
public class PointOfInterestController {

    private final PointOfInterestService pointOfInterestService;
    private final PointOfInterestDtoConverter pointOfInterestDtoConverter;
    private final CategoryService categoryService;

    @GetMapping("/")
    public ResponseEntity<List<PointOfInterest>> findAll(){
        return ResponseEntity.ok().body(pointOfInterestService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<GetPointOfInterestDto> findOne(@PathVariable Long id){
        Optional<PointOfInterest> poi= pointOfInterestService.findOne(id);
        return ResponseEntity.ok().body(pointOfInterestDtoConverter.pointOfInterestToGetPointOfInterestDto(poi.get()));
    }
    @PostMapping("/")
    public ResponseEntity<GetPointOfInterestDto> create(@Valid @RequestBody CreatePointOfInterestDto dto){
        PointOfInterest poi = pointOfInterestDtoConverter.createPointOfInterestToPointOfInterest(dto);
        pointOfInterestService.save(poi);
        GetPointOfInterestDto poiDto = pointOfInterestDtoConverter.pointOfInterestToGetPointOfInterestDto(poi);
        return ResponseEntity.status(HttpStatus.CREATED).body(poiDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        pointOfInterestService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Optional<GetPointOfInterestDto>> edit(@PathVariable Long id, @Valid @RequestBody CreatePointOfInterestDto dto){
        return ResponseEntity.ok().body(pointOfInterestService.edit(id, dto));
    }

}
