package com.simiosMeli.controllers;

import com.simiosMeli.DTO.DnaDto;
//import com.simiosMeli.DTO.MetricasDnaDto;
import com.simiosMeli.DTO.enums.StatusDna;
import com.simiosMeli.services.DnaMetricaService;
import com.simiosMeli.services.DnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping( "/simian")
public class DnaController {

    @Autowired
    private final DnaService dnaService;
    @Autowired
    private final DnaMetricaService dnaMetrica;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String isSimian(@RequestBody DnaDto dnaEntityObj) {
        return dnaService.isSimian(dnaEntityObj.getDna()) ? StatusDna.SIMIOS.name() : StatusDna.HUMANO.name();

    }
}
