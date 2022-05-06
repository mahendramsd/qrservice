package com.msd.qrservice.dto.response;

import com.msd.qrservice.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserResponse {

    private Long userId;
    private String username;
    private String roleName;


    public UserResponse(User user) {
        this.userId = user.getId();
        this.username = user.getUsername();
        this.roleName = user.getRole().getName();
    }
}
