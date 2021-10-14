package com.simiosmeli.controllers;

import com.simiosmeli.controllers.dto.DnaDTO;
import com.simiosmeli.model.enums.TypeDna;
import com.simiosmeli.services.DnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/isSimian")
public class DnaController {

    @Autowired
    private DnaService dnaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TypeDna isSimian(@RequestBody DnaDTO dnaDto) {
        return dnaService.saveDna(dnaDto.getDna());
    }

}
