package com.simiosmeli.service;

import com.simiosmeli.controllers.dto.StatsDTO;
import com.simiosmeli.repositories.DnaRepository;
import com.simiosmeli.services.StatsService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StatsServiceTest {

    @InjectMocks
    private StatsService statsService;

    private DnaRepository dnaRepository;

    @Test
    public void shouldCountStats() {

        // arrange
        StatsDTO statsDTO = new StatsDTO(10, 10, 1);

        // act
        StatsDTO statsDTO1 = new StatsDTO(statsDTO);

        StatsDTO result = statsService.getStats();

        // assert
        Assert.assertEquals(10, result.getCountHumanDna());

        /// TODO: 13/10/21  
    }
}