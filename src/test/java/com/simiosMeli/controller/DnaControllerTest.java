package com.simiosMeli.controller;

import com.simiosMeli.DTO.DnaDto;
import com.simiosMeli.DTO.enums.StatusDna;
import com.simiosMeli.services.DnaService;
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
    public void shouldCheckIfIsSimian() {
        String[] dnaSimios = new String[]{"CAGTAG", "TTTTAT", "GCAGGC", "ACTGAC", "TGAATC"};
        DnaDto dna = new DnaDto(dnaSimios);

        when(dnaService.isSimian(dnaSimios)).thenReturn(false);
        final ResponseEntity<String> response = testRestTemplate.postForEntity("/simian", dna, String.class);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertEquals(StatusDna.HUMANO.name(), response.getBody());
    }
}
