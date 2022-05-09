package com.msd.qrservice.service;

import com.msd.qrservice.dto.response.QrDetailResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface QrService {

    Boolean uploadQrCode(Long userId, String qrType, MultipartFile file);

    List<QrDetailResponse> qrSearch(String qrType, String query);

    Boolean deleteQrCode(Long id, Long userId);
}
