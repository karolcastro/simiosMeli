package com.simiosmeli.services;

import com.simiosmeli.model.Dna;
import com.simiosmeli.model.enums.TypeDna;
import com.simiosmeli.repositories.DnaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DnaService {


    private final DnaRepository dnaRepository;

    public boolean isSimian(String[] dnaSimios) {
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
            return false;
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
            return false;
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
            return false;
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
            return false;
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
            return false;
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
            return false;
        }
        return false;
    }


}

