package com.msd.qrservice.exception;


import com.msd.qrservice.utils.DynamicErrorCodes;

public class DynamicException extends RuntimeException {

    private DynamicErrorCodes dynamicErrorCodes;

    public DynamicException(DynamicErrorCodes dynamicErrorCodes) {
        this.dynamicErrorCodes = dynamicErrorCodes;
    }

    public DynamicErrorCodes getDynamicErrorCodes() {
        return dynamicErrorCodes;
    }
}
