package com.simiosMeli.services;

import com.simiosMeli.DTO.DnaDto;
import com.simiosMeli.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DnaDataBaseService {

    @Autowired
    private DnaRepository dnaRepository;

    public List<DnaDto> findAll() {

        return dnaRepository.findAll();
    }

    public DnaDto findById(Long id) {
        Optional<DnaDto> optionalDnaEntity = dnaRepository.findById(id);
        return optionalDnaEntity.get();
    }

    public DnaDto insert(DnaDto objDnaEntity) {
        return dnaRepository.save(objDnaEntity);
    }

    public void delete(Long id) {
        dnaRepository.deleteById(id);
    }

    public DnaDto update(Long id, DnaDto objDnaEntity) {
        DnaDto dna = dnaRepository.getById(id);
        updateData(dna, objDnaEntity);
        return  dnaRepository.save(dna);
    }

    private void updateData(DnaDto dna, DnaDto objDnaEntity) {
        dna.setDna(objDnaEntity.getDna());
    }
}
