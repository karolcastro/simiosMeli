package com.simiosmeli.controllers;

import com.simiosmeli.controllers.dto.DnaDTO;
import com.simiosmeli.controllers.dto.StatsDTO;
import com.simiosmeli.model.enums.TypeDna;
import com.simiosmeli.services.DnaService;
import com.simiosmeli.services.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/stats")
public class StatsController {

    @Autowired
    private StatsService statsService;

    @GetMapping
    public StatsDTO stats() {
        return statsService.getStats();
    }
}
