package com.simiosMeli.controller;

import com.simiosMeli.entities.DnaEntity;
import com.simiosMeli.repositories.DnaRepository;
import com.simiosMeli.services.DnaService;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DnaControllerTest {

    public static final Long DNA_ID = 1L;

    public static final String[] DNA_SEQUENCE =  {"CAGAT","GTGAT","GGAAT","GCAGC","TTAGC" };

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    public DnaRepository dnaRepository;

    @Test
    public void shouldCheckIfIsHuman() {
        final DnaEntity dna = new DnaEntity(DNA_ID, DNA_SEQUENCE);
        this.dnaRepository.save(dna);

        //final var response = this.testRestTemplate.postForEntity("/simian",null,DnaEntity.class);
        Assertions.assertEquals(HttpStatus.CREATED, dna.getDna());

    }

}
