package com.example.RikMastersTest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "grainRoasting")
public class GrainRoasting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "originCountry")
    private String originCountry;
    @Column(name = "quantity")
    private double quantity;
    @Column(name = "lossPercentage")
    private double lossPercentage;
    @Column(name = "brigadeNumber")
    private UUID brigadeNumber;

}
