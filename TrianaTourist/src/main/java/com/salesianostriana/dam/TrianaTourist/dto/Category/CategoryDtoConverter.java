package com.salesianostriana.dam.TrianaTourist.dto.Category;

import com.salesianostriana.dam.TrianaTourist.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoConverter {

    public Category createCategoryDtoToCategory (CreateCategoryDto dto){
        return Category.builder()
                .name(dto.getName())
                .build();
    }
    public GetCategoryDto CategoryToGetCategoryDto (Category category){
        return GetCategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
