package com.serverless.moneytransfer.processor.impl;

import com.serverless.commons.HttpMethod;
import com.serverless.commons.LambdaRequest;
import com.serverless.commons.LambdaRequestType;
import com.serverless.commons.LambdaResponse;
import com.serverless.commons.error.AppError;
import com.serverless.commons.error.ErrorHandler;
import com.serverless.commons.exception.BadRequestException;
import com.serverless.moneytransfer.processor.RequestDispatcher;
import com.serverless.moneytransfer.processor.TransferService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

public class RequestDispatcherImpl implements RequestDispatcher {

    @Autowired
    private TransferService transferService;

    @Override
    public LambdaResponse dispatchRequest(LambdaRequest lambdaRequest, LambdaResponse lambdaResponse) {
        String requestHttpMethod = lambdaRequest.getHttpMethod();
        LambdaRequestType requestType = getLambdaRequestType(requestHttpMethod, lambdaRequest);
        switch (requestType) {
            case ADD_TRANSFER:
                processAddTransferRequest(lambdaRequest, lambdaResponse);
            case GET_TRANSFERS:
                processGetTransfersRequest(lambdaRequest, lambdaResponse);
            case GET_TRANSFER_BY_ID:
                processGetTransfersByIdRequest(lambdaRequest, lambdaResponse);
            case DELETE_TRANSFER:
                processDeleteTransferRequest(lambdaRequest, lambdaResponse);
            case UPDATE_TRANSFER:
                processUpdateTransfer(lambdaRequest, lambdaResponse);
            default:
                throw new BadRequestException("Invalid Request Type " + requestType.toString());
        }
    }

    private void processUpdateTransfer(LambdaRequest lambdaRequest, LambdaResponse lambdaResponse) {
        String transferId = getPathParam(lambdaRequest);
        if (Objects.nonNull(transferId)) {
            transferService.updateTransferDetails(transferId, lambdaRequest.getTransferRequest(), lambdaResponse);
        }
    }

    private void processDeleteTransferRequest(LambdaRequest lambdaRequest, LambdaResponse lambdaResponse) {
        String transferId = getPathParam(lambdaRequest);
        if (Objects.nonNull(transferId)) {
            transferService.deleteTransferDetails(transferId, lambdaResponse);
        }
    }

    private void processGetTransfersByIdRequest(LambdaRequest lambdaRequest, LambdaResponse lambdaResponse) {
        String transferId = getPathParam(lambdaRequest);
        if (Objects.nonNull(transferId)) {
            transferService.getTransferDetailsById(transferId, lambdaResponse);
        }
    }

    private void processGetTransfersRequest(LambdaRequest lambdaRequest, LambdaResponse lambdaResponse) {
        transferService.getAllTransferDetails();
    }

    private void processAddTransferRequest(LambdaRequest lambdaRequest, LambdaResponse lambdaResponse) {
        if (Objects.nonNull(lambdaRequest) && Objects.nonNull(lambdaRequest.getTransferRequest())) {
            transferService.addTransfers(lambdaRequest.getTransferRequest(), lambdaResponse);
        } else {
            AppError appError = new AppError("Invalid request !!");
            ErrorHandler.handleErrorResponse(lambdaResponse, appError);
        }
    }

    private LambdaRequestType getLambdaRequestType(String requestHttpMethod, LambdaRequest lambdaRequest) {
        String currentResourcePath = getResourcePath(lambdaRequest);
        if (requestHttpMethod.equalsIgnoreCase(HttpMethod.GET.name())) {
            if (currentResourcePath.endsWith("{transferId}")) {
                return LambdaRequestType.GET_TRANSFER_BY_ID;
            } else {
                return LambdaRequestType.GET_TRANSFERS;
            }
        } else if (requestHttpMethod.equalsIgnoreCase(HttpMethod.POST.name())) {
            return LambdaRequestType.ADD_TRANSFER;
        } else if (requestHttpMethod.equalsIgnoreCase(HttpMethod.PUT.name())) {
            return LambdaRequestType.UPDATE_TRANSFER;
        } else if (requestHttpMethod.equalsIgnoreCase(HttpMethod.DELETE.name())) {
            return LambdaRequestType.DELETE_TRANSFER;
        } else {
            throw new BadRequestException("Invalid Request Type !!");
        }
    }

    private String getPathParam(LambdaRequest lambdaRequest) {
        return lambdaRequest.getPathParam(LambdaRequest.PATH_PARAM);
    }

    private String getResourcePath(LambdaRequest lambdaRequest) {
        return lambdaRequest.getResourcePath(LambdaRequest.RESOURCE_PATH);
    }
}
