package com.simiosMeli.controllers;

import com.simiosMeli.entities.DnaEntity;
import com.simiosMeli.services.DnaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/isSimian")
public class DnaController {

    private DnaService dnaService;

    @GetMapping
    public ResponseEntity<DnaEntity> finAll() {

        DnaEntity dna1 = new DnaEntity(1L,"CAGTAA");
        return ResponseEntity.ok().body(dna1);
    }

}
