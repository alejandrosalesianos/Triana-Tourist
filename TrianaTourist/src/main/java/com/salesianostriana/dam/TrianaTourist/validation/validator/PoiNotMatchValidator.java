package com.salesianostriana.dam.TrianaTourist.validation.validator;

import com.salesianostriana.dam.TrianaTourist.validation.multiple.PoiNotMatch;
import org.springframework.beans.PropertyAccessorFactory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PoiNotMatchValidator implements ConstraintValidator<PoiNotMatch, Object> {

    private String coverPhoto;
    private String photo2;
    private String photo3;

    @Override
    public void initialize(PoiNotMatch constraintAnnotation) {
        coverPhoto = constraintAnnotation.CoverPhoto();
        photo2 = constraintAnnotation.Photo2();
        photo3 = constraintAnnotation.Photo3();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Object coverPhotoValue = PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(coverPhoto);
        Object photo2Value = PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(photo2);
        Object photo3Value = PropertyAccessorFactory.forBeanPropertyAccess(value).getPropertyValue(photo3);
        if (coverPhotoValue != null){
            return !coverPhotoValue.equals(photo2Value) && !coverPhotoValue.equals(photo3Value) && !photo2Value.equals(photo3Value);
        }else {
            return coverPhotoValue == null;
        }
    }
}
