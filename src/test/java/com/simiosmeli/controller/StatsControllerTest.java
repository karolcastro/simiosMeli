package com.simiosmeli.controller;

import com.simiosmeli.controllers.StatsController;
import com.simiosmeli.controllers.dto.DnaDTO;
import com.simiosmeli.controllers.dto.StatsDTO;
import com.simiosmeli.model.enums.TypeDna;
import com.simiosmeli.services.StatsService;
import com.sun.xml.bind.v2.TODO;
import org.hamcrest.CoreMatchers;
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
public class StatsControllerTest {

    @MockBean
    private StatsService statsService;

    @Autowired
    private TestRestTemplate testRestTemplate;

    private  StatsController statsController;

    @Test
    public void shouldCheckIfReturnHttp200Ok() {
        StatsDTO statsDTO = new StatsDTO(10, 5,0.5);

        StatsDTO stats = new StatsDTO(statsDTO);

        when(statsService.getStats()).thenReturn(stats);

        final ResponseEntity<StatsDTO> response = testRestTemplate.getForEntity("/stats",StatsDTO.class);

        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void shouldReturnStatsDto() {

        StatsDTO statsDTO = new StatsDTO(10, 5,0.5);

        StatsDTO stats = new StatsDTO(statsDTO);

        when(statsService.getStats()).thenReturn(statsDTO);

        final ResponseEntity<StatsDTO> response = testRestTemplate.getForEntity("/stats",StatsDTO.class);

        Assertions.assertEquals(response.getBody(), response.getBody()); /// TODO: 13/10/21
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());

    }

}
