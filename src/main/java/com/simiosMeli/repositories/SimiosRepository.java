package com.simiosMeli.repositories;

import com.simiosMeli.entities.SimiosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SimiosRepository extends JpaRepository {
    Optional<SimiosEntity> findbyId(Long id);
}
