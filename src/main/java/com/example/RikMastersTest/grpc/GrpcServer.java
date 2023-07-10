package com.example.RikMastersTest.grpc;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(9090)
                .addService(new RoastingService())
                .build();
        server.start();
        server.awaitTermination();
    }
}