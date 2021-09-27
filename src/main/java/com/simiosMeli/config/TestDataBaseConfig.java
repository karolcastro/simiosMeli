package com.simiosMeli.config;

import com.simiosMeli.entities.DnaEntity;
import com.simiosMeli.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.sql.Connection;
import java.util.Arrays;
import java.util.stream.Collectors;

@Configuration
@Profile("test")
public class TestDataBaseConfig implements CommandLineRunner {


    @Autowired
    private DnaRepository dnaRepository;


    @Override
    public void run(String... args) throws Exception {

        //DnaEntity dna2 = new DnaEntity(Arrays.stream(new String[]{"CAGTAA", "TTTTAT", "GCAGGC", "ACTGAC", "TGAATC"}).sequential().map(String::valueOf).collect(Collectors.joining(",")));

        DnaEntity dna1 = new DnaEntity(1L,"TTTTAT");
        DnaEntity dna2 = new DnaEntity(2L,"GCAGGC");
        DnaEntity dna3 = new DnaEntity(3L,"ACTGAC");

        dnaRepository.saveAll(Arrays.asList(dna1,dna2,dna3));
    }
}