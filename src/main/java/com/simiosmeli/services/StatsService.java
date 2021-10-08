package com.simiosmeli.services;

import com.simiosmeli.controllers.dto.StatsDTO;
import com.simiosmeli.model.enums.TypeDna;
import com.simiosmeli.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatsService {

    @Autowired
    private DnaRepository dnaRepository;

    public StatsDTO getStats() {

        int countHuman = dnaRepository.countAllByType(TypeDna.HUMANO);

        int countSimios = dnaRepository.countAllByType(TypeDna.SIMIOS);

        double ratio = countHuman != 0 ? countSimios / countHuman : countSimios;

        return new StatsDTO(countSimios, countHuman, ratio);
    }
}
