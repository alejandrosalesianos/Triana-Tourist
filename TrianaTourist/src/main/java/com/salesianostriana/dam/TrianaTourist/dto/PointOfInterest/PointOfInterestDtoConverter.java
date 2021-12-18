package com.salesianostriana.dam.TrianaTourist.dto.PointOfInterest;

import com.salesianostriana.dam.TrianaTourist.model.Category;
import com.salesianostriana.dam.TrianaTourist.model.PointOfInterest;
import com.salesianostriana.dam.TrianaTourist.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PointOfInterestDtoConverter {
    @Autowired
    private CategoryService categoryService;

    public PointOfInterest createPointOfInterestToPointOfInterest (CreatePointOfInterestDto createPointOfInterestDto){
        Optional<Category> category = categoryService.findOne(createPointOfInterestDto.getCategory());
        return PointOfInterest.builder()
                .name(createPointOfInterestDto.getName())
                .location(createPointOfInterestDto.getLocation())
                .description(createPointOfInterestDto.getDescription())
                .date(createPointOfInterestDto.getDate())
                .category(category.get())
                .coverPhoto(createPointOfInterestDto.getCoverPhoto())
                .photo2(createPointOfInterestDto.getPhoto2())
                .photo3(createPointOfInterestDto.getPhoto3())
                .routes(createPointOfInterestDto.getRoutes())
                .build();
    }
    public GetPointOfInterestDto pointOfInterestToGetPointOfInterestDto (PointOfInterest pointOfInterest){
       return GetPointOfInterestDto.builder()
               .id(pointOfInterest.getId())
               .name(pointOfInterest.getName())
               .location(pointOfInterest.getLocation())
               .description(pointOfInterest.getDescription())
               .date(pointOfInterest.getDate())
               .category(pointOfInterest.getCategory())
               .coverPhoto(pointOfInterest.getCoverPhoto())
               .photo2(pointOfInterest.getPhoto2())
               .photo3(pointOfInterest.getPhoto3())
               .routes(pointOfInterest.getRoutes())
               .build();
    }
}
