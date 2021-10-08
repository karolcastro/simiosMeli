package com.simiosmeli.model;

import com.simiosmeli.model.enums.TypeDna;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@EqualsAndHashCode
@Getter
@Entity
public class Dna implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String dna;

    @Enumerated(EnumType.STRING)
    private TypeDna type;

    public Dna() {

    }

    public Dna(String[] dna, TypeDna typeDna) {
        this.dna = Stream.of(dna).collect(Collectors.joining());
        this.type = typeDna;

    }


}
