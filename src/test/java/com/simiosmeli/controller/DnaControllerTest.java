package com.simiosMeli.controller;

import com.simiosmeli.controllers.DnaController;
import com.simiosmeli.controllers.dto.DnaDTO;
import com.simiosmeli.model.enums.TypeDna;
import com.simiosmeli.services.DnaService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class DnaControllerTest {


    @MockBean
    private DnaService dnaService;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void shouldCheckIfReturnHttp200Ok() {
        String[] dnaSimios = new String[]{"CAGTAG", "TTTTAT", "GCAGGC", "ACTGAC", "TGAATC"};

        when(dnaService.isSimian(dnaSimios)).thenReturn(Boolean.FALSE);

        DnaDTO dna = new DnaDTO(dnaSimios);

        final ResponseEntity<String> response = testRestTemplate.postForEntity("/isSimian", dna, String.class);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void shouldCheckIfIsHuman() {
        String[] dnaSimios = new String[]{"CAGTAG", "TTTTAT", "GCAGGC", "ACTGAC", "TGAATC"};

        DnaDTO dna = new DnaDTO(dnaSimios);

        when(dnaService.saveDna(dnaSimios)).thenReturn(TypeDna.HUMANO);

        final ResponseEntity<String> response = testRestTemplate.postForEntity("/isSimian", dna,String.class);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertEquals("\"HUMANO\"", response.getBody());
    }

    @Test
    public void shouldCheckIfIsSimian() {
        String[] dnaSimios = new String[]{"CAGTAG", "TTTTAT", "GCAGGC", "ACTGAC", "TGAATC"};

        DnaDTO dna = new DnaDTO(dnaSimios);

        when(dnaService.saveDna(dnaSimios)).thenReturn(TypeDna.SIMIOS);

        final ResponseEntity<String> response = testRestTemplate.postForEntity("/isSimian", dna,String.class);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertEquals("\"SIMIOS\"", response.getBody());
    }
}
