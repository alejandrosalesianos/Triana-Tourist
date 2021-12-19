package com.salesianostriana.dam.TrianaTourist.validation.validator;

import com.salesianostriana.dam.TrianaTourist.repository.CategoryRepository;
import com.salesianostriana.dam.TrianaTourist.repository.RouteRepository;
import com.salesianostriana.dam.TrianaTourist.validation.simple.UniqueName;
import com.salesianostriana.dam.TrianaTourist.validation.simple.UniqueNameRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameRouteValidator implements ConstraintValidator<UniqueNameRoute, String> {

    @Autowired
    private RouteRepository routeRepository;

    @Override
    public void initialize(UniqueNameRoute constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return StringUtils.hasText(value) && !routeRepository.existsByName(value);
    }
}
