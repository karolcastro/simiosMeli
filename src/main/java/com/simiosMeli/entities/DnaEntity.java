package com.simiosMeli.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "dna")
public class DnaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dna;

    public DnaEntity() {
    }

    public DnaEntity(Long id, String dna) {
        this.id = id;
        this.dna = dna;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDna() {
        return dna;
    }

    public void setDna(String dna) {
        this.dna = dna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DnaEntity)) return false;
        DnaEntity dnaEntity = (DnaEntity) o;
        return Objects.equals(getId(), dnaEntity.getId()) && Objects.equals(getDna(), dnaEntity.getDna());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDna());
    }
}
