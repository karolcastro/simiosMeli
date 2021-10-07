package com.simiosMeli.controllers;

import com.simiosMeli.DTO.DnaDto;
import com.simiosMeli.DTO.enums.StatusDna;
import com.simiosMeli.services.DnaDataBaseService;
import com.simiosMeli.services.DnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableJpaRepositories
@RequestMapping(value = "/isSimian")
public class DnaDataController {

    @Autowired
    private DnaDataBaseService dnaDataBaseService;

    @Autowired
    private DnaService dnaService;


    @GetMapping(value = "/{dna}")
    public ResponseEntity <DnaDto> findByDna(@PathVariable String[] dnaDto){
        DnaDto dnaList = dnaDataBaseService.findByDna(dnaDto);
        return ResponseEntity.ok().body(dnaList);

    }

    @GetMapping
    public ResponseEntity<List<DnaDto>> findAll(StatusDna statusDna) {
        List <DnaDto> dnaStatusList = dnaDataBaseService.findAll(statusDna);
        return ResponseEntity.ok().body(dnaStatusList);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String isSimian(@RequestBody DnaDto dnaDto) {
        return dnaService.isSimian(dnaDto.getDna()) ? StatusDna.SIMIOS.name() : StatusDna.HUMANO.name();
    }

}
