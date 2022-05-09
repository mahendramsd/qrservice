package com.msd.qrservice.controller;

import com.msd.qrservice.dto.response.QrDetailResponse;
import com.msd.qrservice.service.QrService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class QrControllerTest {

    @InjectMocks
    QrController qrController;

    @Mock
    private QrService qrService;

    @Test
    public void uploadQRCodeTest(){
        Long userId = 1L;
        MultipartFile multipartFile = new MockMultipartFile("sourceFile.png", "Hello World".getBytes());
        String qrType = "text";

        Mockito.when(qrService.uploadQrCode(userId,qrType,multipartFile)).thenReturn(true);

        Assert.assertEquals(true,qrController.uploadQRCode(userId,multipartFile,qrType).getBody().getData());
    }

    @Test
    public void uploadQRCodeTest1(){
        Long userId = 1L;
        MultipartFile multipartFile = new MockMultipartFile("sourceFile.png", "www.example.com".getBytes());
        String qrType = "url";

        Mockito.when(qrService.uploadQrCode(userId,qrType,multipartFile)).thenReturn(true);

        Assert.assertEquals(true,qrController.uploadQRCode(userId,multipartFile,qrType).getBody().getData());
    }

    @Test
    public void qrCodeSearchTest(){
        String qrType = "text";
        String query = "text";

        List<QrDetailResponse> qrDetailResponseList = new ArrayList<>();

        Mockito.when(qrService.qrSearch(qrType,query)).thenReturn(qrDetailResponseList);

        Assert.assertEquals(qrDetailResponseList,qrController.qrCodeSearch(qrType,query).getBody().getData());
    }
    @Test
    public void deleteQrCodeTest(){
        Long qrId = 1L;
        Long userId = 1L;

        Mockito.when(qrService.deleteQrCode(qrId,userId)).thenReturn(true);

        Assert.assertEquals(true,qrController.deleteQrCode(qrId,userId).getBody().getData());
    }
}
