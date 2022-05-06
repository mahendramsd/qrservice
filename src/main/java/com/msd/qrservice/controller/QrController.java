package com.msd.qrservice.controller;

import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qr")
@ResponseStatus(HttpStatus.OK)
@Api(value = "QR Controller")
public class QrController {

}
