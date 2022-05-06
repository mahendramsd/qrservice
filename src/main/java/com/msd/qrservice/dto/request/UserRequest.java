package com.msd.qrservice.dto.request;

import lombok.Data;

@Data
public class UserRequest {
    private String username;
    private String password;
    private Integer roleId;

}
