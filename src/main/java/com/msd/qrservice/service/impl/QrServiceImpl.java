package com.msd.qrservice.service.impl;

import com.msd.qrservice.domain.QrDetail;
import com.msd.qrservice.domain.User;
import com.msd.qrservice.dto.enums.QrType;
import com.msd.qrservice.dto.enums.Status;
import com.msd.qrservice.dto.response.QrDetailResponse;
import com.msd.qrservice.exception.CustomException;
import com.msd.qrservice.repositories.QrRepository;
import com.msd.qrservice.repositories.UserRepository;
import com.msd.qrservice.service.QrService;
import com.msd.qrservice.utils.Constants;
import com.msd.qrservice.utils.CustomErrorCodes;
import ezvcard.Ezvcard;
import ezvcard.VCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

@Service
public class QrServiceImpl implements QrService {

    private static final Logger logger = LoggerFactory.getLogger(QrServiceImpl.class);

    private final QrRepository qrRepository;
    private final UserRepository userRepository;

    public QrServiceImpl(QrRepository qrRepository, UserRepository userRepository) {
        this.qrRepository = qrRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Boolean uploadQrCode(Long userId, String qrType, MultipartFile file) {
        try {
            InputStream inputStream = file.getInputStream();
            BinaryBitmap binaryBitmap
                    = new BinaryBitmap(new HybridBinarizer(
                    new BufferedImageLuminanceSource(
                            ImageIO.read(inputStream))));
            Result result
                    = new MultiFormatReader().decode(binaryBitmap);
            logger.debug("QR DATA : {}", result.getText());

            QrDetail qrDetail = new QrDetail();
            qrDetail.setQrType(QrType.getQrType(qrType));
            qrDetail.setFileName(file.getOriginalFilename());
            qrDetail.setStatus(Status.ACTIVE);

            if (QrType.VCARD.equals(QrType.getQrType(qrType))) {
                VCard vcard = Ezvcard.parse(result.getText()).first();
                String json = Ezvcard.writeJson(vcard).go();
                logger.debug("vcard Data DATA : {}", json);
                qrDetail.setData(json);
            } else {
                qrDetail.setData(result.getText());
            }
            qrRepository.save(qrDetail);
            logger.debug("QR Code Data Updated : {}");
        } catch (IOException | NotFoundException e) {
            logger.error("vQR Code invalid or not found : {}", file.getOriginalFilename());
            throw new CustomException(CustomErrorCodes.INVALID_QR_CODE);
        }
        return true;
    }

    @Override
    public List<QrDetailResponse> qrSearch(String qrType, String query) {
        List<QrDetail> qrDetails = qrRepository.findByQrTypeAndDataContainingIgnoreCase(QrType.getQrType(qrType), query);
        return qrDetails.stream().map(QrDetailResponse::new).collect(Collectors.toList());
    }

    @Override
    public Boolean deleteQrCode(Long id, Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent() && user.get().getRole().getId() == Constants.USER_ROLE_ADMIN) {
            qrRepository.deleteById(id);
            return true;
        } else {
            throw new CustomException(CustomErrorCodes.ADMIN_PERMISSION_REQUIRED);
        }
    }
}
