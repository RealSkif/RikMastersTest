package com.example.RikMastersTest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "grainStock")
public class GrainStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private static int weightOfBag = 60_000;

    @Column(name = "grain_type")
    private String grainType;

    @Column(name = "origin_country")
    private String originCountry;

    @Column(name = "quantity")
    private double quantity;

}