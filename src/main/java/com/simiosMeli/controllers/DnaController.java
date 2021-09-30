package com.simiosMeli.controllers;

import com.simiosMeli.entities.DnaEntity;
import com.simiosMeli.entities.enums.StatusDna;
import com.simiosMeli.services.DnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping( "/simian")
public class DnaController {

    private final DnaService dnaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String isSimian(@RequestBody DnaEntity dnaEntityObj) {
        return dnaService.isSimian(dnaEntityObj.getDna()) ? StatusDna.SIMIOS.name() : StatusDna.HUMANO.name();

    }

}
