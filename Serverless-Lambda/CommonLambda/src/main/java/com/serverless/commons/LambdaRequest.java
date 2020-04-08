package com.serverless.commons;

import java.util.Map;
import java.util.Objects;

public class LambdaRequest {

    public static final String RESOURCE_PATH = "resource-path";
    public static final String PATH_PARAM = "path-param";

    private Map<String, String> headers;
    private Map<String, String> queryStringParameters;
    private Map<String, String> pathParameters;
    private Map<String, Object> requestContext;
    private String httpMethod;

    private TransferRequest transferRequest;

    public TransferRequest getTransferRequest() {
        return transferRequest;
    }

    public void setTransferRequest(TransferRequest transferRequest) {
        this.transferRequest = transferRequest;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> getQueryStringParameters() {
        return queryStringParameters;
    }

    public void setQueryStringParameters(Map<String, String> queryStringParameters) {
        this.queryStringParameters = queryStringParameters;
    }

    public Map<String, String> getPathParameters() {
        return pathParameters;
    }

    public void setPathParameters(Map<String, String> pathParameters) {
        this.pathParameters = pathParameters;
    }

    public Map<String, Object> getRequestContext() {
        return requestContext;
    }

    public void setRequestContext(Map<String, Object> requestContext) {
        this.requestContext = requestContext;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getResourcePath(String paramKey) {
        if (requestContext == null) {
            return null;
        } else {
            return String.valueOf(requestContext.get(paramKey));
        }
    }

    public String getPathParam(String pathParams) {
        if (Objects.nonNull(pathParameters)) {
            return pathParameters.get(pathParams);
        }
        return null;
    }
}
