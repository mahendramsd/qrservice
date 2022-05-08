package com.msd.qrservice.repositories;

import com.msd.qrservice.domain.QrDetail;
import com.msd.qrservice.dto.enums.QrType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QrRepository extends JpaRepository<QrDetail,Long> {

    List<QrDetail> findByQrTypeAndDataContainingIgnoreCase(QrType qrType, String query);
}
