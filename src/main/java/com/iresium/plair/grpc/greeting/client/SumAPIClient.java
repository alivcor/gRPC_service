package com.iresium.plair.grpc.greeting.client;

import com.proto.sumapi.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class SumAPIClient {

    public static void main(String[] args) {

        System.out.println("Hello from gRPC Client");

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();

        SumAPIServiceGrpc.SumAPIServiceBlockingStub syncClient = SumAPIServiceGrpc.newBlockingStub(channel);

        SumAPIRequest request = SumAPIRequest.newBuilder().setNum1(5).setNum2(6).build();

        SumAPIResponse response = syncClient.getSum(request);
        System.out.println("The sum is " + response.getResult());


        channel.shutdown();

    }

}
