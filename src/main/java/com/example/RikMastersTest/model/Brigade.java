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
@Table(name = "brigade")
public class Brigade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "brigade_number")
    private int brigadeNumber;

    @Column(name = "loss_percentage")
    private double lossPercentage;
//public void roast( String quantity, String grainType,String originCountry)
}