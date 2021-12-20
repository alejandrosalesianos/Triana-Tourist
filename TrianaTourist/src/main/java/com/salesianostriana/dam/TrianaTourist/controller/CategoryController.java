package com.salesianostriana.dam.TrianaTourist.controller;

import com.salesianostriana.dam.TrianaTourist.dto.Category.CategoryDtoConverter;
import com.salesianostriana.dam.TrianaTourist.dto.Category.CreateCategoryDto;
import com.salesianostriana.dam.TrianaTourist.dto.Category.GetCategoryDto;
import com.salesianostriana.dam.TrianaTourist.model.Category;
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
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryDtoConverter categoryDtoConverter;
    private final PointOfInterestService pointOfInterestService;

    @GetMapping("/")
    public ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.ok().body(categoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCategoryDto> findOne(@PathVariable Long id){
        return ResponseEntity.ok().body(categoryDtoConverter.CategoryToGetCategoryDto(categoryService.findOne(id).get()));
    }

    @PostMapping("/")
    public ResponseEntity<GetCategoryDto> create(@Valid @RequestBody CreateCategoryDto dto){
        Category category = categoryDtoConverter.createCategoryDtoToCategory(dto);
        categoryService.save(category);
        GetCategoryDto categoryDto = categoryDtoConverter.CategoryToGetCategoryDto(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(categoryDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        Category category = categoryService.findOne(id).get();
        category.nullearCategoriaDePoi(pointOfInterestService.findAll());
        categoryService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Optional<GetCategoryDto>> edit(@PathVariable Long id,@Valid @RequestBody CreateCategoryDto dto){
        return ResponseEntity.ok().body(categoryService.edit(id,dto));
    }
}
