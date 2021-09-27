package com.simiosMeli.config;

import com.simiosMeli.entities.DnaEntity;
import com.simiosMeli.repositories.DnaRepository;
import com.simiosMeli.services.DnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;

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

        dnaRepository.save(dna2);

        DnaService dnaService = new DnaService();

        String[] dna = new String[] {"CAGTAG", "TTTCAT", "GCAGGC", "ACTGAC", "TGAATC"};

        boolean result = dnaService.isSimian(dna2);
        System.out.println(String.format("O resultado é: %s", result));
    }
}