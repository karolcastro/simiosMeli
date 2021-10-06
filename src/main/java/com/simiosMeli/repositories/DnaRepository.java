package com.simiosMeli.repositories;


import com.simiosMeli.DTO.DnaDto;
import com.simiosMeli.DTO.enums.StatusDna;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DnaRepository extends JpaRepository<DnaDto, Long> {

    DnaDto findByDna(String[] dnaSimios);

    List<DnaDto> findAll(StatusDna statusDna);

    DnaDto isSimian(String[] dnaSimios);
}

