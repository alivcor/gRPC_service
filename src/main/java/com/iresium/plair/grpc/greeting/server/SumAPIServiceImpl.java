package com.iresium.plair.grpc.greeting.server;

import com.proto.sumapi.SumAPIRequest;
import com.proto.sumapi.SumAPIResponse;
import com.proto.sumapi.SumAPIServiceGrpc;
import io.grpc.stub.StreamObserver;

public class SumAPIServiceImpl extends SumAPIServiceGrpc.SumAPIServiceImplBase {
    @Override
    public void getSum(SumAPIRequest request, StreamObserver<SumAPIResponse> responseObserver) {

        Integer num1 = request.getNum1();
        Integer num2 = request.getNum2();

        SumAPIResponse response = SumAPIResponse.newBuilder().setResult(num1+num2).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
//        super.sumAPI(request, responseObserver);
    }
}
