package com.salesianostriana.dam.TrianaTourist.error.excepciones;

import javax.persistence.EntityNotFoundException;

public class ListEntityNotFound extends EntityNotFoundException {

    public ListEntityNotFound (Class clase){
        super(String.format("No se pudo encontrar la lista de clase: %s",clase.getName()));
    }
}
