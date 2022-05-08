package com.msd.qrservice.dto.enums;

import java.util.HashMap;
import java.util.Map;

public enum QrType {

    TEXT("text"),URL("url"),VCARD("vCard");

    private static final Map<String, QrType> qrTypeByValue = new HashMap<String, QrType>();

    static {
        for (QrType type : QrType.values()) {
            qrTypeByValue.put(type.qrType, type);
        }
    }

    final String qrType;

    QrType(String status) {
        this.qrType = status;
    }

    public static QrType getQrType(String value) {
        return qrTypeByValue.get(value);
    }


}
