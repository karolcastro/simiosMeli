package com.simiosMeli.services;

import com.simiosMeli.entities.SimiosEntity;
import com.simiosMeli.repositories.SimiosRepository;
import com.simiosMeli.services.exceptions.ResourceNotFoundException;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;

import java.util.List;
import java.util.Optional;

public class SimiosService {

    private SimiosRepository simiosRepository;

    public List<SimiosEntity> findAll() {
        return simiosRepository.findAll();
    }

    public SimiosEntity findbyId(Long id ) {
        Optional<SimiosEntity> simios = simiosRepository.findbyId(id);
        return simios.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
