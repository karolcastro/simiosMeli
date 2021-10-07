package com.simiosMeli.services;

import com.simiosMeli.DTO.DnaDto;
import com.simiosMeli.DTO.enums.StatusDna;

import com.simiosMeli.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DnaDataBaseService {

    @Autowired
    private DnaRepository dnaRepository;

    private DnaService dnaService;


    public DnaDto findByDna(String[] dnaDto) {
        DnaDto dnaList = dnaRepository.findByDna(dnaDto);

        if (Objects.nonNull(dnaList)) {
            throw new Error("DNA encontra-se na base de dados");
        }
        return dnaRepository.findByDna(dnaDto);
    }

    public List<DnaDto> findAll(StatusDna statusDna) {
        return dnaRepository.findAll(statusDna);
    }

    public void saveDna(String[] dna, StatusDna statusDna) {
        DnaDto save = dnaRepository.findByDna(dna);
        if (save == null) {
            save.setDna(dna);
            save.setStatusDna(statusDna);
            dnaRepository.save(save);
        }
    }

    public void saveDna(StatusDna statusDna) {
    }
}
