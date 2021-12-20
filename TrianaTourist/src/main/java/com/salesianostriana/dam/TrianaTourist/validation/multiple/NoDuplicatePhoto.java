package com.salesianostriana.dam.TrianaTourist.validation.multiple;

import com.salesianostriana.dam.TrianaTourist.validation.validator.NoDuplicatePhotoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NoDuplicatePhotoValidator.class)
@Target(ElementType.TYPE)
@Documented
public @interface NoDuplicatePhoto {

    String message() default "No puede haber fotos duplicadas";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String[] photos();
}
