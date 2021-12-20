package com.salesianostriana.dam.TrianaTourist.validation.multiple;

import com.salesianostriana.dam.TrianaTourist.validation.validator.PoiNotMatchValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Constraint(validatedBy = PoiNotMatchValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PoiNotMatch {

    String message() default "Las fotos no pueden coincidir";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String CoverPhoto();
    String Photo2();
    String Photo3();

}
