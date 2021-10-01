package com.simiosMeli.controllers;

import com.simiosMeli.DTO.DnaDto;
//import com.simiosMeli.DTO.MetricasDnaDto;
import com.simiosMeli.DTO.enums.StatusDna;
import com.simiosMeli.services.DnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping( "/simian")
public class DnaController {

    @Autowired
    private final DnaService dnaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String isSimian(@RequestBody DnaDto dnaDto) {
        return dnaService.isSimian(dnaDto.getDna()) ? StatusDna.SIMIOS.name() : StatusDna.HUMANO.name();
    }

}
