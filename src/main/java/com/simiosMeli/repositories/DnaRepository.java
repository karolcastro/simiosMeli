package com.simiosMeli.repositories;


import com.simiosMeli.entities.DnaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DnaRepository extends JpaRepository<DnaEntity, Long> {
}
