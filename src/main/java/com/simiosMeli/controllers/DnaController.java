package com.simiosMeli.controllers;

import com.simiosMeli.entities.DnaEntity;
import com.simiosMeli.entities.enums.StatusDna;
import com.simiosMeli.services.DnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DnaController {

    private final DnaService dnaService;

    @PostMapping(value = "/simian")
    public StatusDna isSimian(@RequestBody DnaEntity dnaEntityObj) {
        return dnaService.isSimian(dnaEntityObj.getDna()) ? StatusDna.SIMIOS : StatusDna.HUMANO;
    }

}
