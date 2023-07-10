package com.example.RikMastersTest.grpc;

public class GrainRoastingRequest {
    private String originCountry;
    private double quantity;
    private double outputWeight;
    private String teamNumber;

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getTeamNumber() {
        return teamNumber;
    }

    public void setTeamNumber(String teamNumber) {
        this.teamNumber = teamNumber;
    }

    public double getOutputWeight() {
        return outputWeight;
    }

    public void setOutputWeight(double outputWeight) {
        this.outputWeight = outputWeight;
    }

}

