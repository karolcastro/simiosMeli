package com.simiosMeli.validations;

public class ArrayValidation {
    public void arrayValidation(String[] array) throws ArrayIndexOutOfBoundsException{
        if (array == null || array.length < 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}
