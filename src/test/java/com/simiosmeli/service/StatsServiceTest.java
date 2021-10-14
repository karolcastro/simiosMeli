package com.simiosmeli.service;

import com.simiosmeli.controllers.dto.StatsDTO;
import com.simiosmeli.repositories.DnaRepository;
import com.simiosmeli.services.DnaService;
import com.simiosmeli.services.StatsService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
class StatsServiceTest {

    @InjectMocks
    private StatsService statsService ;

    @MockBean
    private DnaRepository dnaRepository;

    @Test
    public void shouldCountStats() {

        // arrange
        StatsDTO statsDTO = new StatsDTO(10, 10 , 1);

        // act
        StatsDTO result = this.statsService.getStats();

        // assert
        Assert.assertEquals( statsDTO.getCountHumanDna(), result.getCountHumanDna());

        /// TODO: 13/10/21  
    }
}