package com.simiosMeli.services.exceptions;

public class IOException extends RuntimeException{
    public IOException (Object dna){

        super("DNA " + dna + " not found. ");
    }
}
