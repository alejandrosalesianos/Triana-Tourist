package com.salesianostriana.dam.TrianaTourist.validation.validator;

import com.salesianostriana.dam.TrianaTourist.validation.multiple.NoDuplicatePhoto;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NoDuplicatePhotoValidator implements ConstraintValidator<NoDuplicatePhoto, Object> {

    String[] photos;

    @Override
    public void initialize(NoDuplicatePhoto constraintAnnotation) {
        this.photos = constraintAnnotation.photos();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {

        for(int i = 0; i< photos.length; i++) {
            Object field = PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(photos[i]);
            for (int j = i + 1; j < photos.length; j++) {
                Object field2 = PropertyAccessorFactory.forBeanPropertyAccess(o).getPropertyValue(photos[j]);
                if (field.equals(field2)) {
                    return false;
                }
            }
        }
        return true;
    }
}
