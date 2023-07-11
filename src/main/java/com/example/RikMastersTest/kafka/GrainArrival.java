package com.example.RikMastersTest.kafka;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GrainArrival {
    private String grainId;
    private double weight;
    private String originCountry;
//    private double robustaPercentage;
//    private double arabicaPercentage;
    private String grainType;
}

