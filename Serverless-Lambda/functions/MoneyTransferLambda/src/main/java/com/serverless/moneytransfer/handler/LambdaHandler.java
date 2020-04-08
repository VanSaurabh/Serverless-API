package com.serverless.moneytransfer.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.serverless.commons.LambdaRequest;
import com.serverless.commons.LambdaResponse;
import com.serverless.commons.base.handler.LambdaBaseHandler;
import com.serverless.moneytransfer.processor.RequestDispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LambdaHandler extends LambdaBaseHandler implements RequestHandler<LambdaRequest, LambdaResponse> {
    private Logger logger = LoggerFactory.getLogger(LambdaHandler.class);

    @Override
    public LambdaResponse handleRequest(LambdaRequest lambdaRequest, Context context) {
        initializeApplication();

        LambdaResponse lambdaResponse = new LambdaResponse();
        try {
            applicationContext.getBean(RequestDispatcher.class).dispatchRequest(lambdaRequest, lambdaResponse);
        } catch (Exception e) {
            logger.error("Got exception while dispatching requests... :" + e.toString());
        }
        return lambdaResponse;
    }
}
