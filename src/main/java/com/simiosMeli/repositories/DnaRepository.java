package com.simiosMeli.repositories;


import com.simiosMeli.DTO.DnaDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DnaRepository extends JpaRepository<DnaDto, Long> {
}
