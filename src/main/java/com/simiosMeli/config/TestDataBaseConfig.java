package com.simiosMeli.config;

import com.simiosMeli.entities.DnaEntity;
import com.simiosMeli.repositories.DnaRepository;
import com.simiosMeli.services.DnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.sql.Connection;
import java.util.Arrays;
import java.util.stream.Collectors;

//@Configuration
@RequiredArgsConstructor
@Profile("test")
public class TestDataBaseConfig implements CommandLineRunner {

    private DnaRepository dnaRepository;

    @Override
    public void run(String... args) throws Exception {

        String[] dna2 = new String[]{"CAGTAA", "TTTTAT", "GCAGGC", "ACTGAC", "TGAATC"};

        //DnaEntity dna1 = new DnaEntity(1L,"TTTTAT");
        //DnaEntity dna2 = new DnaEntity(2L,"GCAGGC");
        //DnaEntity dna3 = new DnaEntity(3L,"ACTGAC");

        //dnaRepository.save(dna);

        DnaService dnaService = new DnaService();

        String[] dna = new String[] {"CAGA", "TTTA", "GCAA", "AAAA"};

        boolean result = dnaService.isSimianHorizontal(dna);
        System.out.println(String.format("O resultado é: %s", result));
    }
}