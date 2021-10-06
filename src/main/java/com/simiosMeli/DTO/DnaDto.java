package com.simiosMeli.DTO;

import com.simiosMeli.DTO.enums.StatusDna;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "dna")
public class DnaDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dna;

    private StatusDna statusDna;

    public DnaDto() {

    }

    public DnaDto(Long id, String[] dna, StatusDna statusDna) {
        this.id = id;
        this.dna = dna;
        this.statusDna = statusDna;

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

    public StatusDna getStatusDna() {

        return statusDna;
    }

    public void setStatusDna(StatusDna statusDna) {
        this.statusDna = statusDna;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DnaDto)) return false;
        DnaDto dnaDto = (DnaDto) o;
        return Objects.equals(getId(), dnaDto.getId()) && Arrays.equals(getDna(), dnaDto.getDna()) && getStatusDna() == dnaDto.getStatusDna();
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getStatusDna());
        result = 31 * result + Arrays.hashCode(getDna());
        return result;
    }
}
