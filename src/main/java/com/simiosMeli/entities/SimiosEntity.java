package com.simiosMeli.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_dna")
public class SimiosEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dna;


    public SimiosEntity() {

    }

    public SimiosEntity(Long id, String dna) {
        this.id = id;
        this.dna = dna;
    }

    public Long getId() {
        return id;
    }

    public Long setId() {
        return id;
    }

    public String getDna() {
        return dna;
    }

    public String setDna() {
        return dna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimiosEntity that = (SimiosEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(dna, that.dna);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dna);
    }
}
