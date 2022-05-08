package com.msd.qrservice.dto.response;

import com.msd.qrservice.domain.QrDetail;
import lombok.Data;

@Data
public class QrDetailResponse {

    private Long id;
    private String qrType;
    private String data;

    public QrDetailResponse(QrDetail qrDetail) {
        this.id = qrDetail.getId();
        this.qrType = qrDetail.getQrType().name();
        this.data = qrDetail.getData();
    }
}
