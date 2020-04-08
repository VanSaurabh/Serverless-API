package com.serverless.moneytransfer.processor.impl;

import com.serverless.commons.LambdaResponse;
import com.serverless.commons.TransferRequest;
import com.serverless.commons.builder.ModelBuilder;
import com.serverless.commons.dao.TransferDao;
import com.serverless.commons.error.AppError;
import com.serverless.commons.error.ErrorHandler;
import com.serverless.commons.model.TransferDetail;
import com.serverless.moneytransfer.processor.TransferService;
import org.springframework.beans.factory.annotation.Autowired;

public class TransferServiceImpl implements TransferService {

    @Autowired
    private TransferDao transferDao;

    @Override
    public void addTransfers(TransferRequest transferRequest, LambdaResponse lambdaResponse) {
        TransferDetail transferDetail = ModelBuilder.buildTransferDetails(transferRequest);
        try {
            TransferDetail returnTransferDetail = transferDao.save(transferDetail);
            ErrorHandler.handleSuccessResponse(lambdaResponse, returnTransferDetail);
        } catch (Exception ex) {
            AppError appError = new AppError(ex.toString());
            ErrorHandler.handleExceptionResponse(lambdaResponse, appError);
        }
    }

    @Override
    public void updateTransferDetails(String transferId, TransferRequest transferRequest,
                                      LambdaResponse lambdaResponse) {

    }

    @Override
    public void deleteTransferDetails(String transferId, LambdaResponse lambdaResponse) {

    }

    @Override
    public void getTransferDetailsById(String transferId, LambdaResponse lambdaResponse) {

    }

    @Override
    public void getAllTransferDetails() {

    }
}
