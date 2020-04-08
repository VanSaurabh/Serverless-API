package com.serverless.moneytransfer.processor;

import com.serverless.commons.LambdaRequest;
import com.serverless.commons.LambdaResponse;
import com.serverless.commons.exception.BadRequestException;

public interface RequestDispatcher {
    LambdaResponse dispatchRequest(LambdaRequest lambdaRequest, LambdaResponse lambdaResponse) throws BadRequestException;
}
