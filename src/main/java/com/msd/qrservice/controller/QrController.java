package com.msd.qrservice.controller;

import com.msd.qrservice.dto.response.QrDetailResponse;
import com.msd.qrservice.service.QrService;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RestController
@RequestMapping("/qr")
@ResponseStatus(HttpStatus.OK)
@Api(value = "QR Controller")
public class QrController {

    private final QrService qrService;

    public QrController(QrService qrService) {
        this.qrService = qrService;
    }

    /**
     * QR Code Upload API
     * @param userId
     * @param file
     * @param qrType
     * @return
     */
    @PostMapping(value = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ApiOperation(value = "Search QR")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Content-Type", value = "application/json", paramType = "header",required = true),
            @ApiImplicitParam(name = "Authorization", value = "Generated access token",
                    paramType = "header",required = true)})
    public ResponseEntity<Void> uploadQRCode(
            @ApiIgnore @RequestAttribute("user-id") Long userId,
            @RequestParam(value = "file",required = true) MultipartFile file,
            @ApiParam(value = "text/url/vCard", required = true)
            @RequestParam("qrType") String qrType) {
        qrService.uploadQrCode(userId, qrType, file);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    /**
     * QR Code Search API
     * @param qrType
     * @param query
     * @return
     */
    @GetMapping(value = "/search")
    @ApiOperation(value = "Search QR", response = QrDetailResponse.class)
    public ResponseEntity<List<QrDetailResponse>> qrCodeSearch(@ApiParam(value = "text/url/vCard")
                                                               @RequestParam(value = "qrType", required = true) String qrType,
                                                               @RequestParam("query") String query) {
        return ResponseEntity.ok(qrService.qrSearch(qrType, query));
    }

    /**
     * QR Code Delete API
     * @param userId
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete QR")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "Content-Type", value = "application/json", paramType = "header",required = true),
            @ApiImplicitParam(name = "Authorization", value = "Generated access token",
                    paramType = "header",required = true)})
    public ResponseEntity<Void> deleteQrCode(
            @ApiIgnore @RequestAttribute("user-id") Long userId,
            @PathVariable("id") Long id) {
        qrService.deleteQrCode(id, userId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
