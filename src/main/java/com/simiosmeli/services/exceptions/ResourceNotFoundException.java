package com.simiosmeli.services.exceptions;

import java.util.Arrays;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String msg) {

        super("Matriz DNA com letras inválidas");
    }

    public ResourceNotFoundException() {

    }
}
