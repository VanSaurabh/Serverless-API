package com.serverless.commons.builder;

import com.serverless.commons.TransferRequest;
import com.serverless.commons.model.TransferDetail;

public class ModelBuilder {

    public static TransferDetail buildTransferDetails(TransferRequest transferRequest) {
        TransferDetail transferDetail = new TransferDetail();
        transferDetail.setDepositAccountNumber(transferRequest.getDepositAccountNumber());
        transferDetail.setId(Long.valueOf(transferRequest.getId()));
        transferDetail.setTransactionAmount(transferRequest.getTransactionAmount());
        transferDetail.setWithdrawAccountNumber(transferRequest.getWithdrawAccountNumber());
        return transferDetail;
    }
}