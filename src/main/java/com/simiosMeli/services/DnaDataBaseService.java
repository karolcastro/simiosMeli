package com.simiosMeli.services;

import com.simiosMeli.DTO.DnaDto;
import com.simiosMeli.DTO.enums.StatusDna;
import com.simiosMeli.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DnaDataBaseService {

    @Autowired
    private DnaRepository dnaRepository;


    public List<String[]> findAll(StatusDna statusDna) {
        return dnaRepository.findAll(statusDna);
    }

    public DnaDto findByDna(String[] dnaSimios) {
        return dnaRepository.findByDna(dnaSimios);
    }
}
