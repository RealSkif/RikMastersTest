//package com.example.RikMastersTest.grpc;
//
//import com.example.RikMastersTest.model.GrainRoasting;
//import com.example.RikMastersTest.service.GrainRoastingService;
//import io.grpc.stub.StreamObserver;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//
//import java.util.UUID;
//import com.example.RikMastersTest.grpc.GrainRoastingRequest;
//import com.example.RikMastersTest.grpc.GrainRoastingServiceGrpc;
//import io.grpc.ManagedChannel;
//import io.grpc.ManagedChannelBuilder;
//import io.grpc.Server;
//import io.grpc.ServerBuilder;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//
//import java.io.IOException;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class RoastingServiceIntegrationTest {
//
//    private static Server server;
//    private static ManagedChannel channel;
//
//    @BeforeAll
//    public static void setup() throws IOException {
//        // Start the gRPC server
//        server = ServerBuilder.forPort(9090)
//                .addService(new RoastingService())
//                .build();
//        server.start();
//
//        // Create a channel to communicate with the server
//        channel = ManagedChannelBuilder.forAddress("localhost", 9090)
//                .usePlaintext()
//                .build();
//    }
//
//    @AfterAll
//    public static void tearDown() {
//        // Shutdown the channel and server
//        channel.shutdownNow();
//        server.shutdownNow();
//    }
//
//    @Test
//    public void testRoastGrain() {
//        // Create a gRPC client stub using the channel
//        GrainRoastingServiceGrpc.GrainRoastingServiceBlockingStub stub = GrainRoastingServiceGrpc.newBlockingStub(channel);
//
//        // Create a gRPC request
//        GrainRoastingRequest request = GrainRoastingRequest.newBuilder()
//                .setOriginCountry("Country")
//                .setQuantity(10.0)
//                .setOutputWeight(8.0)
//                .setBrigadeNumber("12345")
//                .build();
//
//        // Call the gRPC method and get the response
//        CoffeeService.GrainRoastingResponse response = stub.roastGrain(request);
//
//        // Assert the response or perform further verifications
//        assertEquals("ExpectedResponse", response.getSomeField());
//
//        // Verify the context of the request
//        assertEquals("Country", request.getOriginCountry());
//        assertEquals(10.0, request.getQuantity());
//        assertEquals(8.0, request.getOutputWeight());
//        assertEquals("12345", request.getBrigadeNumber());
//    }
//
//}
//}
//
