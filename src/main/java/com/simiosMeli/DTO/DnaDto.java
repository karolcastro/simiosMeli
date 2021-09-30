package com.simiosMeli.DTO;

import com.simiosMeli.DTO.enums.DnaEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "dna")
public class DnaDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String[] dna;

    public DnaDto() {

    }

    public DnaDto(Long id, String[] dna) {
        this.id = id;
        this.dna = dna;

    }

    public DnaDto(String[] dnaSimios) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String[] getDna() {
        return dna;
    }

    public void setDna(String[] dna) {
        this.dna = dna;
    }

    public double getSubTotal() {
        id ++;
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DnaDto)) return false;
        DnaDto dnaEntity = (DnaDto) o;
        return Objects.equals(getId(), dnaEntity.getId()) && Objects.equals(getDna(), dnaEntity.getDna());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDna());
    }
}
