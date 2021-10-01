package com.simiosMeli.controllers;

import com.simiosMeli.DTO.DnaDto;
import com.simiosMeli.DTO.enums.StatusDna;
import com.simiosMeli.services.DnaDataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/isSimian")
public class DnaDataController {

    @Autowired
    private DnaDataBaseService dnaDataBaseService;

    @GetMapping
    public ResponseEntity<List<String[]>> findAll(StatusDna statusDna) {
        List <String[]> dnaList = dnaDataBaseService.findAll(statusDna);
        return ResponseEntity.ok().body(dnaList);
    }

}
