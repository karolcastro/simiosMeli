package com.simiosmeli.services.exceptions;

import java.util.Arrays;

public class InvalidLetters extends RuntimeException{

    public InvalidLetters(String[] msg) {

        super("Matriz DNA com letras inválidas");
    }

}
