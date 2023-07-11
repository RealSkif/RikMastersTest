package com.example.RikMastersTest.grpc;


import com.example.RikMastersTest.model.GrainRoasting;
import com.example.RikMastersTest.service.GrainRoastingService;
import io.grpc.stub.StreamObserver;

import java.util.UUID;

public class RoastingService extends GrainRoastingServiceGrpc.GrainRoastingServiceImplBase {
    GrainRoastingService grainRoastingService;

    @Override
    public void roastGrain(GrainRoastingRequest request,
                           StreamObserver<CoffeeService.GrainRoastingResponse> responseObserver) {
        String originCountry = request.getOriginCountry();
        double quantity = request.getQuantity();
        UUID brigadeNumber = UUID.fromString(request.getBrigadeNumber());
        double outputWeight = request.getOutputWeight();
        double lossPercentage = calculateLossPercentage(quantity, outputWeight);

        GrainRoasting grainRoasting = new GrainRoasting();
        grainRoasting.setBrigadeNumber(brigadeNumber);
        grainRoasting.setOriginCountry(originCountry);
        grainRoasting.setQuantity(quantity);
        grainRoasting.setLossPercentage(lossPercentage);

        grainRoastingService.save(grainRoasting);

    }

    private double calculateLossPercentage(double quantity, double outputWeight) {
        return outputWeight / quantity * 100;
    }
}