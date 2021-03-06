package com.simiosmeli.services;

import com.simiosmeli.controllers.dto.DnaDTO;
import com.simiosmeli.model.Dna;
import com.simiosmeli.model.enums.TypeDna;
import com.simiosmeli.repositories.DnaRepository;
import com.simiosmeli.services.exceptions.InvalidSizeMatriz;
import com.simiosmeli.services.exceptions.InvalidLetters;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class DnaService {

    private final DnaRepository dnaRepository;

    public boolean isSimian(String[] dnaSimios) {

        arrayValid(dnaSimios);
        validationDna(dnaSimios);

        return isSimianHorizontal(dnaSimios) || isSimianVertical(dnaSimios) || isSimianDiagonalPrincipalParaBaixo(dnaSimios) ||
                isSimianDiagonalPrincipalParaCima(dnaSimios) || isSimianDiagonalSecundariaParaCimaEsquerda(dnaSimios)
                || isSimianDiagonalSecundariaParaCimaDireita(dnaSimios);
    }

    public TypeDna saveDna(String[] dnaSimios) {
        boolean isSimian = this.isSimian(dnaSimios);
        TypeDna typeDna = isSimian ? TypeDna.SIMIOS : TypeDna.HUMANO;
        dnaRepository.save(new Dna(dnaSimios, typeDna));
        return typeDna;

    }


    private DnaDTO arrayValid(String[] dnaDTO) throws StringIndexOutOfBoundsException {
        if (dnaDTO.length < 4) {
            throw new InvalidSizeMatriz(dnaDTO);
        }
        return null;
    }

    private DnaDTO validationDna(String[] dnaSimios) throws InvalidLetters {

        final Set<String> DNA_LETTER = new HashSet<>(Arrays.asList("A", "G", "C", "T"));

        for (int i = 0; i < dnaSimios.length; i++) {
            for (int j = 0; j < dnaSimios.length; j++) {
                if (!DNA_LETTER.contains(dnaSimios[i])) {
                    throw new InvalidLetters(dnaSimios);
                }
                if (!DNA_LETTER.contains(dnaSimios[j])) {
                    throw new InvalidLetters(dnaSimios);
                }
            }
        }
        return null;
    }

    private static boolean isSimianHorizontal(String[] dnaSimios) {

            int sizeMatriz = dnaSimios.length;


            for (int line = 0; line < sizeMatriz; line++) {
                char letra = ' ';
                int count = 0;

                try{
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

            }catch (StringIndexOutOfBoundsException e) {
                    throw new InvalidSizeMatriz(dnaSimios);
                }
            }

        return false;

    }

    private static boolean isSimianVertical(String[] dnaSimios) {
        int sizeMatriz = dnaSimios.length;


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

        return false;
    }

    private static boolean isSimianDiagonalPrincipalParaBaixo(String[] dnaSimios) {

        int sizeMatriz = dnaSimios.length;


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

        return false;

    }

    private static boolean isSimianDiagonalPrincipalParaCima(String[] dnaSimios) {

        int sizeMatriz = dnaSimios.length;


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

        return false;

    }

    private static boolean isSimianDiagonalSecundariaParaCimaEsquerda(String[] dnaSimios) {

        int sizeMatriz = dnaSimios.length;


            for (int column = sizeMatriz - 1; column >= 0; column--) {
                char letra = ' ';
                int count = 0;

                try {
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
                catch (ArrayIndexOutOfBoundsException e) {
                    throw new InvalidLetters(dnaSimios);
                }
            }

        return false;

    }

    private static boolean isSimianDiagonalSecundariaParaCimaDireita(String[] dnaSimios) {

        int sizeMatriz = dnaSimios.length;
        boolean result = false;

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
        return false;
    }


}

