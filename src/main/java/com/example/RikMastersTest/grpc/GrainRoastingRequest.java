package com.example.RikMastersTest.grpc;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GrainRoastingRequest {
    private String originCountry;
    private double quantity;
    private double outputWeight;
    private String brigadeNumber;
}

