package com.simiosmeli.controllers.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StatsDTO {

    private int countSimiosDna;

    private int countHumanDna;

    private double ratio;


    public StatsDTO(StatsDTO statsDTO) {
    }
}
