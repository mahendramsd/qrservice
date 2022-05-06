package com.msd.qrservice.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@RequiredArgsConstructor
public class InvalidGradeException extends RuntimeException {

    private final String gradeId;

    @Override
    public String getMessage() {
        return "Provided Grade Id is not Equal with Grade Id in Request Body :" + gradeId;
    }

}
