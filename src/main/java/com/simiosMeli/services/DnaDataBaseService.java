package com.simiosMeli.services;

import com.simiosMeli.entities.DnaEntity;
import com.simiosMeli.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DnaDataBaseService {

    @Autowired
    private DnaRepository dnaRepository;

    public List<DnaEntity> findAll() {
        return dnaRepository.findAll();
    }

    public DnaEntity findById(Long id) {
        Optional<DnaEntity> optionalDnaEntity = dnaRepository.findById(id);
        return optionalDnaEntity.get();
    }

    public DnaEntity insert(DnaEntity objDnaEntity) {
        return dnaRepository.save(objDnaEntity);
    }

    public void delete(Long id) {
        dnaRepository.deleteById(id);
    }

    public DnaEntity update(Long id, DnaEntity objDnaEntity) {
        DnaEntity dna = dnaRepository.getById(id);
        updateData(dna, objDnaEntity);
        return  dnaRepository.save(dna);
    }

    private void updateData(DnaEntity dna, DnaEntity objDnaEntity) {
        dna.setDna(objDnaEntity.getDna());
    }
}
