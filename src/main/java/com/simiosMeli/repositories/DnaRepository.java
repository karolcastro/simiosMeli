package com.simiosMeli.repositories;


import com.simiosMeli.DTO.DnaDto;
import com.simiosMeli.DTO.enums.StatusDna;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DnaRepository extends JpaRepository<String[], Long> {

    DnaDto findByDna(String[] dnaSimios);

    List<String[]> findAll(StatusDna statusDna);
}

