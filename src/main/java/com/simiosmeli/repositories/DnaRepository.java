package com.simiosmeli.repositories;

import com.simiosmeli.model.Dna;
import com.simiosmeli.model.enums.TypeDna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DnaRepository extends JpaRepository<Dna, Long> {

    int countAllByType(TypeDna typeDna);
}
