package com.msd.qrservice.dto.response;

import com.msd.qrservice.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginResponse {

    private Long userId;
    private String username;
    private String roleName;
    private String accessToken;


    public LoginResponse(User user) {
        this.userId = user.getId();
        this.accessToken = user.getAccessToken();
        this.username = user.getUsername();
//        this.roleName = user.get
    }
}
