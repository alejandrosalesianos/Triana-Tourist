package com.salesianostriana.dam.TrianaTourist.validation.validator;

import com.salesianostriana.dam.TrianaTourist.model.PointOfInterest;
import com.salesianostriana.dam.TrianaTourist.validation.simple.UniquePoiInRoute;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;
import java.util.List;

public class UniquePoiInRouteValidator implements ConstraintValidator<UniquePoiInRoute, List<PointOfInterest>> {

    private boolean repetido;

    @Override
    public void initialize(UniquePoiInRoute constraintAnnotation) {
    }

    @Override
    public boolean isValid(List<PointOfInterest> pointOfInterestList, ConstraintValidatorContext constraintValidatorContext) {
        for (int i = 0; i < pointOfInterestList.size(); i++) {
            if (!pointOfInterestList.contains(pointOfInterestList.get(i))) {
                repetido = false;
            } else {
                repetido = true;
            }
        }
        return repetido;
    }
}
