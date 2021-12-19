package com.salesianostriana.dam.TrianaTourist.service;

import com.salesianostriana.dam.TrianaTourist.dto.Category.CategoryDtoConverter;
import com.salesianostriana.dam.TrianaTourist.dto.Category.CreateCategoryDto;
import com.salesianostriana.dam.TrianaTourist.dto.Category.GetCategoryDto;
import com.salesianostriana.dam.TrianaTourist.error.excepciones.EntidadNotFoundException;
import com.salesianostriana.dam.TrianaTourist.error.excepciones.ListEntityNotFound;
import com.salesianostriana.dam.TrianaTourist.model.Category;
import com.salesianostriana.dam.TrianaTourist.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryDtoConverter categoryDtoConverter;

    public List<Category> findAll(){
        if (categoryRepository.findAll().isEmpty()){
            throw new ListEntityNotFound(Category.class);
        }else {
            return categoryRepository.findAll();
        }
    }
    public Optional<Category> findOne(Long id){
        if (categoryRepository.findById(id).isEmpty()){
            throw new EntidadNotFoundException(id,Category.class);
        }
        return categoryRepository.findById(id);
    }
    public void deleteById(Long id){
        if (categoryRepository.findById(id).isEmpty()){
            throw new EntidadNotFoundException(id,Category.class);
        }else{
            categoryRepository.deleteById(id);
        }
    }
    public void save(Category category){
        categoryRepository.save(category);
    }
    public Optional<GetCategoryDto> edit(Long id, CreateCategoryDto dto){
        return findOne(id).map(nuevo ->{
            nuevo.setName(dto.getName());
            save(nuevo);
            return categoryDtoConverter.CategoryToGetCategoryDto(nuevo);
        });
    }
}
