package com.simiosMeli.services;

import com.simiosMeli.DTO.DnaDto;
import com.simiosMeli.repositories.DnaRepository;
import com.simiosMeli.services.exceptions.MatrizNaoQuadradaException;
import com.simiosMeli.validations.ArrayValidation;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service
public class DnaService {


    public boolean isSimian(String[] dnaSimios) {


        arrayValidation(dnaSimios);
        sequenceValidation(dnaSimios);

        return isSimianHorizontal(dnaSimios) || isSimianVertical(dnaSimios) || isSimianDiagonalPrincipalParaBaixo(dnaSimios) ||
                isSimianDiagonalPrincipalParaCima(dnaSimios) || isSimianDiagonalSecundariaParaCimaEsquerda(dnaSimios) || isSimianDiagonalSecundariaParaCimaDireita(dnaSimios);
    }

    public static void arrayValidation(String[] dnaSimios) throws ArrayIndexOutOfBoundsException {
        if (dnaSimios.length < 4 || dnaSimios == null) {
            throw new  Error("Dna não pode estar vazio ou menor que uma sequencia de 4");
        }
    }

    public static void sequenceValidation(String[] dnaSimios) {

        Set sequenceValidDna = new HashSet<>(Arrays.asList("A","T","C","G"));

        for (int i =0; i < dnaSimios.length; i++){
            for (int j = 0; j < dnaSimios.length; j++) {
                if (!sequenceValidDna.contains(dnaSimios[i])){
                    throw new  Error("Sequencia de DNA inválida");
                }
                if (!sequenceValidDna.contains(dnaSimios[j])) {
                    throw new  Error("Sequencia de DNA inválida");
                }
            }
        }
    }

    public static boolean isSimianHorizontal(String[] dnaSimios) {
        try {
            int sizeMatriz = dnaSimios.length;

            for (int line = 0; line < sizeMatriz; line++) {
                char letra = ' ';
                int count = 0;

                for (int column = 0; column < sizeMatriz; column++) {
                    String dnaSquence = dnaSimios[line];
                    char dnaChar = dnaSquence.charAt(column);

                    if (dnaChar != letra) {
                        count = 1;
                        letra = dnaChar;
                    } else {
                        count++;
                    }
                    if (count == 4) {
                        return true;
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new MatrizNaoQuadradaException(dnaSimios);
        }
        return false;

    }

    public static boolean isSimianVertical(String[] dnaSimios) {
        int sizeMatriz = dnaSimios.length;

        try {
            for (int column = 0; column < sizeMatriz; column++) {
                char letra = ' ';
                int count = 0;

                for (int line = 0; line < sizeMatriz; line++) {
                    String dnaSquence = dnaSimios[line];
                    char dnaChar = dnaSquence.charAt(column);

                    if (dnaChar != letra) {
                        count = 1;
                        letra = dnaChar;
                    } else {
                        count++;
                    }
                    if (count == 4) {
                        return true;
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new MatrizNaoQuadradaException(dnaSimios);
        }
        return false;
    }

    public static boolean isSimianDiagonalPrincipalParaBaixo(String[] dnaSimios) {

        int sizeMatriz = dnaSimios.length;

        try {
            for (int column = sizeMatriz - 1; column < sizeMatriz; column++) {
                char letra = ' ';
                int count = 0;

                for (int line = 0; line < sizeMatriz - column; line++) {
                    String dnaSquence = dnaSimios[line + column];
                    char dnaChar = dnaSquence.charAt(line);

                    if (letra != dnaChar) {
                        letra = dnaChar;

                        count = 1;
                    } else {
                        count++;
                    }
                    if (count == 4) {
                        return true;
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new MatrizNaoQuadradaException(dnaSimios);
        }
        return false;

    }

    public static boolean isSimianDiagonalPrincipalParaCima(String[] dnaSimios) {

        int sizeMatriz = dnaSimios.length;
        try {

            for (int column = 0; column >= 0; column--) {
                char letra = ' ';
                int count = 0;

                for (int line = sizeMatriz - 1; line >= 0; line--) {
                    String dnaSquence = dnaSimios[line - column];
                    char dnaChar = dnaSquence.charAt(line);

                    if (letra != dnaChar) {
                        letra = dnaChar;
                        count = 1;
                    } else {
                        count++;
                    }
                    if (count == 4) {
                        return true;
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new MatrizNaoQuadradaException(dnaSimios);
        }
        return false;

    }

    public static boolean isSimianDiagonalSecundariaParaCimaEsquerda(String[] dnaSimios) {

        int sizeMatriz = dnaSimios.length;

        try {
            for (int column = sizeMatriz - 1; column >= 0; column--) {
                char letra = ' ';
                int count = 0;

                for (int line = 0; line < sizeMatriz - 1; line++) {
                    String dnaSquence = dnaSimios[column - line];
                    char dnaChar = dnaSquence.charAt(line);

                    if (letra != dnaChar) {
                        letra = dnaChar;
                        count = 1;
                    } else {
                        count++;
                    }
                    if (count == 4) {
                        return true;
                    }
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new MatrizNaoQuadradaException(dnaSimios);
        }
        return false;

    }

    public static boolean isSimianDiagonalSecundariaParaCimaDireita(String[] dnaSimios) {

        int sizeMatriz = dnaSimios.length;
        boolean result = false;

        try {
            for (int column = 0; column < sizeMatriz; column++) {
                char letra = ' ';
                int count = 0;
                int count2 = 0;

                for (int line = sizeMatriz - 1; line >= 0; line--) {
                    var dnaSimio = dnaSimios[line];
                    String dnaSquence = dnaSimios[line];
                    int sum = column + count2;
                    if (sum < sizeMatriz - 1) {
                        count2++;
                    }
                    char dnaChar = dnaSquence.charAt(column + count2);

                    if (letra != dnaChar) {
                        letra = dnaChar;
                        count = 1;
                    } else {
                        count++;
                    }
                    if (count == 4) {
                        return result = true;
                    }
                }
            }
        } catch (StringIndexOutOfBoundsException e) {
            throw new MatrizNaoQuadradaException(dnaSimios);
        }
        return false;
    }


}

