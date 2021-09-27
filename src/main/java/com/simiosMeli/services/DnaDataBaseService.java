package com.simiosMeli.services;

import com.simiosMeli.entities.DnaEntity;
import com.simiosMeli.repositories.DnaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DnaDataBaseService {

    private final DnaRepository dnaRepository;

    public List<String[]> findAll() {
        return dnaRepository.findAll();
    }

    public String[] findById(Long id) {
        Optional<String[]> optionalDnaEntity = dnaRepository.findById(id);
        return optionalDnaEntity.get();
    }

    public String[] insert(String[] objDnaEntity) {
        return dnaRepository.save(objDnaEntity);
    }

    public void delete(Long id) {
        dnaRepository.deleteById(id);
    }

    public String[] update(Long id, DnaEntity objDnaEntity) {
        String[] dna = dnaRepository.getById(id);
        return  dnaRepository.save(dna);
    }

    private void updateData(DnaEntity dna, DnaEntity objDnaEntity) {
        dna.setDna(objDnaEntity.getDna());
    }
}
