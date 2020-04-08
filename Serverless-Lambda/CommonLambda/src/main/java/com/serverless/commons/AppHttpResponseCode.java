package com.serverless.commons;

public enum AppHttpResponseCode {

    SUCCESS("S200"), NOT_FOUND("F404"), BAD_REQUEST("F400"), INTERNAL_ERROR("F500"),
    CREATED("S201");

    String code;

    AppHttpResponseCode(String code) {
        this.code = code;
    }
}
