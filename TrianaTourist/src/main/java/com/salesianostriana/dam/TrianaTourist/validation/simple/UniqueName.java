package com.salesianostriana.dam.TrianaTourist.validation.simple;

import com.salesianostriana.dam.TrianaTourist.validation.validator.UniqueNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD,ElementType.METHOD})
@Constraint(validatedBy = UniqueNameValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UniqueName {

    String message() default "Esta categoria ya esta creada";
    Class <?> [] groups() default {};
    Class <? extends Payload> [] payload() default {};

}
