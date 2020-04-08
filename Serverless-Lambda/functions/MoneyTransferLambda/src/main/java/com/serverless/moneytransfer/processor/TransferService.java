package com.serverless.moneytransfer.processor;

import com.serverless.commons.LambdaResponse;
import com.serverless.commons.TransferRequest;

public interface TransferService {
    void addTransfers(TransferRequest transferRequest, LambdaResponse lambdaResponse);

    void updateTransferDetails(String transferId, TransferRequest transferRequest, LambdaResponse lambdaResponse);

    void deleteTransferDetails(String transferId, LambdaResponse lambdaResponse);

    void getTransferDetailsById(String transferId, LambdaResponse lambdaResponse);

    void getAllTransferDetails();
}
