package com.simiosmeli.services.exceptions;

import java.util.Arrays;

public class StringIndexOutOfBoundsException extends RuntimeException{

    public StringIndexOutOfBoundsException(String[] dna) {
        super("Matriz DNA " + Arrays.toString(dna) + " não é uma matriz quadrada. ");
    }
}
