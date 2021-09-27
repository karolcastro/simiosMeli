package com.simiosMeli.services;


import com.simiosMeli.entities.DnaEntity;
import com.simiosMeli.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.nio.file.OpenOption;
import java.util.List;
import java.util.Optional;

@Service
public class DnaService {

    @Autowired
    private DnaRepository dnaRepository;

    public List<DnaEntity> findAll() {
        return dnaRepository.findAll();
    }

    public DnaEntity findById(Long id) {
        Optional<DnaEntity> optionalDnaEntity = dnaRepository.findById(id);
        return optionalDnaEntity.get();
    }

    public DnaEntity insert(DnaEntity objDnaEntity) {
        return dnaRepository.save(objDnaEntity);
    }

    public boolean isSimian(String[] dnaSimios) {

        return isSimianHorizontal(dnaSimios) || isSimianVertical(dnaSimios) || isSimianDiagonalPrincipalParaBaixo(dnaSimios) ||
                isSimianDiagonalPrincipalParaCima(dnaSimios) || isSimianDiagonalSecundariaParaCimaEsquerda(dnaSimios) || isSimianDiagonalSecundariaParaCimaDireita(dnaSimios);
    }

    public boolean isSimianHorizontal(String[] dnaSimios) {

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
            throw new ArrayIndexOutOfBoundsException(e.getMessage());
        }
        return false;

    }

    public static boolean isSimianVertical(String[] dnaSimios) {

        try {

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
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException(e.getMessage());
        }
        return false;
    }

    public static boolean isSimianDiagonalPrincipalParaBaixo(String[] dnaSimios) {

        try {

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
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new ArrayIndexOutOfBoundsException(e.getMessage());
        }
        return false;

    }

    public static boolean isSimianDiagonalPrincipalParaCima(String[] dnaSimios) {

        int sizeMatriz = dnaSimios.length;
        try {

            for (int column = 0; column < sizeMatriz; column--) {
                char letra = ' ';
                int count = 0;

                for (int line = sizeMatriz - 1; line >= 0; line++) {
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
            throw new ArrayIndexOutOfBoundsException(e.getMessage());
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
            throw new ArrayIndexOutOfBoundsException(e.getMessage());
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
                    char dnaChar = dnaSquence.charAt(column + count2);
                    count2++;

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
            System.out.println(" Error");
        }
        return false;
    }
}

