package com.msd.qrservice.dto.enums;

import java.util.HashMap;
import java.util.Map;

public enum Status {

    ACTIVE("ACTIVE"), INACTIVE("INACTIVE"), DELETE("DELETE"), VERIFIED("VERIFIED"), REJECTED("REJECTED");

    private static final Map<String, Status> statusByValue = new HashMap<String, Status>();

    static {
        for (Status type : Status.values()) {
            statusByValue.put(type.status, type);
        }
    }

    final String status;

    Status(String status) {
        this.status = status;
    }

    public static Status getStatus(String value) {
        return statusByValue.get(value);
    }


}
