package com.salesianostriana.dam.TrianaTourist.validation.validator;

import com.salesianostriana.dam.TrianaTourist.repository.CategoryRepository;
import com.salesianostriana.dam.TrianaTourist.validation.simple.UniqueName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void initialize(UniqueName constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.hasText(value) && !categoryRepository.existsByName(value);
    }
}
