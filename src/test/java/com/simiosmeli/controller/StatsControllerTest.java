package com.simiosmeli.controller;

import com.simiosmeli.controllers.DnaController;
import com.simiosmeli.controllers.StatsController;
import com.simiosmeli.controllers.dto.DnaDTO;
import com.simiosmeli.controllers.dto.StatsDTO;
import com.simiosmeli.model.enums.TypeDna;
import com.simiosmeli.services.DnaService;
import com.simiosmeli.services.StatsService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.when;

public class StatsControllerTest {

    @MockBean
    private StatsService statsService;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private StatsController statsController;

    @Test
    public void shouldCheckIfReturnHttp200Ok() {

        StatsDTO statsDTO = new StatsDTO(15, 5,0.3);

        when(statsService.getStats()).thenReturn(statsDTO);

        final StatsDTO response = statsController.stats();

        Assertions.assertEquals(HttpStatus.CREATED,  response.getCountHumanDna());


    }
}
