package com.serverless.commons.error;

import com.serverless.commons.AppHttpResponseCode;
import com.serverless.commons.LambdaResponse;
import com.serverless.commons.model.TransferDetail;

public class ErrorHandler {

    public static void handleErrorResponse(LambdaResponse lambdaResponse, AppError appError) {
        lambdaResponse.setHttpStatusCode(Integer.valueOf(AppHttpResponseCode.INTERNAL_ERROR.ordinal()));
        lambdaResponse.setBody(appError);
    }

    public static void handleSuccessResponse(LambdaResponse lambdaResponse, TransferDetail returnTransferDetail) {
        lambdaResponse.setHttpStatusCode(Integer.valueOf(AppHttpResponseCode.SUCCESS.ordinal()));
        lambdaResponse.setBody(returnTransferDetail);
    }

    public static void handleExceptionResponse(LambdaResponse lambdaResponse, AppError appError) {
        lambdaResponse.setHttpStatusCode(Integer.valueOf(AppHttpResponseCode.SUCCESS.ordinal()));
        lambdaResponse.setBody(appError);
    }
}
