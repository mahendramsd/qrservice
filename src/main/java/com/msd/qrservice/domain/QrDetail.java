package com.msd.qrservice.domain;

import com.msd.qrservice.dto.enums.QrType;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity(name = "qr_detail")
@Data
public class QrDetail extends BaseEntityMaster {

    @Column(name = "qr_type")
    @Enumerated(EnumType.STRING)
    private QrType qrType;

    @Column(name = "data")
    private String data;

    @Column(name = "file_name")
    private String fileName;
}
