package com.salesianostriana.dam.TrianaTourist.validation.simple;

import com.salesianostriana.dam.TrianaTourist.validation.validator.UniqueNameRouteValidator;
import com.salesianostriana.dam.TrianaTourist.validation.validator.UniqueNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.METHOD})
@Constraint(validatedBy = UniqueNameRouteValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniqueNameRoute {

    String message() default "Esta ruta ya esta creada";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

}
