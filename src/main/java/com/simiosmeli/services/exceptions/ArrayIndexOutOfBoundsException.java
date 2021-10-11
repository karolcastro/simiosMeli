package com.simiosmeli.services.exceptions;

import java.util.Arrays;

public class ArrayIndexOutOfBoundsException extends RuntimeException{

    public ArrayIndexOutOfBoundsException (String[] dna){

        super("Matriz DNA " + Arrays.toString(dna) + " não é uma matriz quadrada. ");
    }
}
