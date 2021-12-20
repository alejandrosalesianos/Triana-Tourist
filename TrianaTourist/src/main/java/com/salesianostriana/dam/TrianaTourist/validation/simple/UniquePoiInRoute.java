package com.salesianostriana.dam.TrianaTourist.validation.simple;

import com.salesianostriana.dam.TrianaTourist.validation.validator.UniquePoiInRouteValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.METHOD})
@Constraint(validatedBy = UniquePoiInRouteValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniquePoiInRoute {

    String message() default "No puede haber elementos repetidos en la ruta";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};


}
