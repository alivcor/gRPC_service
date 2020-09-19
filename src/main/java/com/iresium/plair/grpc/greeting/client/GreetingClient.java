package com.iresium.plair.grpc.greeting.client;

import com.proto.dummy.DummyServiceGrpc;
import com.proto.greet.GreetRequest;
import com.proto.greet.GreetResponse;
import com.proto.greet.GreetServiceGrpc;
import com.proto.greet.Greeting;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GreetingClient {
    public static void main(String[] args) {
        System.out.println("Hello from gRPC Client");

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .build();

//        DummyServiceGrpc.DummyServiceBlockingStub syncClient = DummyServiceGrpc.newBlockingStub(channel);

//        DummyServiceGrpc.DummyServiceFutureStub asyncClient = DummyServiceGrpc.newFutureStub(channel);

        GreetServiceGrpc.GreetServiceBlockingStub syncClient = GreetServiceGrpc.newBlockingStub(channel);


        Greeting greeting = Greeting.newBuilder().setFirstName("Abhi").setLastName("D").build();
        GreetRequest request = GreetRequest.newBuilder().setGreeting(greeting).build();

        GreetResponse response = syncClient.greet(request);

        channel.shutdown();


    }
}
