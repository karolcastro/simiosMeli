package com.simiosMeli.gateway;

import com.simiosMeli.DTO.DnaDto;
import com.simiosMeli.repositories.DnaRepository;

public class DnaGateway {
    private final DnaRepository dnaRepository;

    public DnaGateway(DnaRepository dnaRepository) {
        this.dnaRepository = dnaRepository;
    }

    public DnaDto create(final DnaDto dnaDto) {
        return dnaRepository.save(dnaDto);
    }
}
