package com.msd.qrservice.utils;

import org.springframework.http.HttpStatus;

public enum CustomErrorCodes {
    USER_ALREADY_EXIST(1000, "User Name already exist", HttpStatus.BAD_REQUEST),
    USER_ROLE_NOT_FOUNT(1001, "User role not found", HttpStatus.BAD_REQUEST),
    USER_DISABLED(1002, "USER_DISABLED", HttpStatus.BAD_REQUEST),
    INVALID_CREDENTIALS(1003, "INVALID_CREDENTIALS", HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(1004, "User Not Found", HttpStatus.BAD_REQUEST),
    INVALID_QR_CODE(1005, "Invalid QR Code or Not found", HttpStatus.NOT_FOUND),
    ADMIN_PERMISSION_REQUIRED(1006, "Admin Permission required for delete Qr Data", HttpStatus.UNAUTHORIZED);


    private final int id;
    private final String msg;
    private final HttpStatus httpCode;

    CustomErrorCodes(int id, String msg, HttpStatus httpCode) {
        this.id = id;
        this.msg = msg;
        this.httpCode = httpCode;
    }

    public int getId() {
        return this.id;
    }

    public String getMsg() {
        return this.msg;
    }

    public HttpStatus getHttpCode() {
        return this.httpCode;
    }

}
