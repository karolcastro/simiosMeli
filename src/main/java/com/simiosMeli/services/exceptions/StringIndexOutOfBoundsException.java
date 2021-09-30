package com.simiosMeli.services.exceptions;

import java.util.Arrays;

public class StringIndexOutOfBoundsException extends MatrizNaoQuadradaException{

    public StringIndexOutOfBoundsException(String[] dna) {
        super("Matriz DNA " + Arrays.toString(dna) + " não é uma matriz quadrada. ");
    }
}
