package com.simiosMeli.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

public interface DnaRepository extends JpaRepository<String[], Long> {
}
