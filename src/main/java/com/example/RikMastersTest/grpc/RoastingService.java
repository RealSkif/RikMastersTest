package com.example.RikMastersTest.grpc;


import com.example.RikMastersTest.service.BrigadeService;
import io.grpc.stub.StreamObserver;

import java.awt.image.BaseMultiResolutionImage;

public class RoastingService extends GrainRoastingServiceGrpc.GrainRoastingServiceImplBase {

    @Override
    public void roastGrain(GrainRoastingRequest request, StreamObserver<CoffeeService.GrainRoastingResponse> responseObserver) {
        String originCountry = request.getOriginCountry();
        double quantity = request.getQuantity();
        String teamNumber = request.getTeamNumber();
        double outputWeight = request.getOutputWeight();
        double lossPercentage = calculateLossPercentage(quantity, outputWeight);


    }

    private double calculateLossPercentage(double quantity, double outputWeight) {

        return outputWeight/quantity * 100;
    }
}