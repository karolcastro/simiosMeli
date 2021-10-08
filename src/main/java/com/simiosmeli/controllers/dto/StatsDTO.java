package com.simiosmeli.controllers.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StatsDTO {

    private int countSimiosDna;

    private int countHumanDna;

    private double ratio;


}
