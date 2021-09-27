package com.simiosMeli.controllers;

import com.simiosMeli.entities.DnaEntity;
import com.simiosMeli.services.DnaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/isSimian")
public class DnaController {

    @Autowired
    private DnaService dnaService;

    @GetMapping
    public ResponseEntity<List<DnaEntity>> finAll() {
        List<DnaEntity> dnaList = dnaService.findAll();
        DnaEntity dna1 = new DnaEntity(1L,"CAGTAA");
        return ResponseEntity.ok().body(dnaList);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<DnaEntity> findById(@PathVariable Long id) {
        DnaEntity objDnaEntity = dnaService.findById(id);
        return ResponseEntity.ok().body(objDnaEntity);
    }

}
