package com.simiosmeli.services.exceptions;

import java.util.Arrays;

public class InvalidSizeMatriz extends RuntimeException{

    public InvalidSizeMatriz(String[] dna){

        super("Matriz DNA " + Arrays.toString(dna) + " não é uma matriz quadrada. ");
    }
}
