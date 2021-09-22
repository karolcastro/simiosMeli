package com.simiosMeli.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(Object id) {
        super("ID " + id + " not found. ");
    }
}
