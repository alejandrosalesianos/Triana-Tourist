package com.salesianostriana.dam.TrianaTourist.error.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntidadNotFoundException extends RuntimeException{

   public EntidadNotFoundException(Long id,Class clase){
       super(String.format("No se encontro la clase %s con la id: %s",clase.getName(),id));
   }
}
