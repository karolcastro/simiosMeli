package com.simiosMeli.services.exceptions;

public class StringIndexOutOfBoundsException extends RuntimeException{

    public StringIndexOutOfBoundsException(Object dna) {

        super("DNA " + dna + " not found. ");
    }
}
