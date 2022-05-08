package com.msd.qrservice.service;

import com.google.zxing.NotFoundException;
import com.msd.qrservice.dto.response.QrDetailResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface QrService {

    void uploadQrCode(Long userId, String qrType, MultipartFile file);

    List<QrDetailResponse> qrSearch(String qrType, String query);

    void deleteQrCode(Long id, Long userId);
}
