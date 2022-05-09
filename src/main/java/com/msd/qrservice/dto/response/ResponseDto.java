package com.msd.qrservice.dto.response;

import com.msd.qrservice.dto.enums.ResponseStatus;
import lombok.Data;

@Data
public class ResponseDto {

    private ResponseStatus status;
    private Object data;

    public ResponseDto() {
        super();
    }

    public ResponseDto(ResponseStatus status, Object data) {
        this.status = status;
        this.data = data;
    }
    public static ResponseDto success(Object data) {
        return new ResponseDto(ResponseStatus.OK,data);
    }

    public static ResponseDto fail(Object data) {
        return new ResponseDto(ResponseStatus.FAIL,data);
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "status=" + status +
                ", data=" + data +
                '}';
    }
}
