package com.simiosMeli.services.exceptions;

public class ArrayIndexOutOfBoundsException extends RuntimeException{

    public ArrayIndexOutOfBoundsException (Object dna){

        super("DNA " + dna + " not found. ");
    }
}
