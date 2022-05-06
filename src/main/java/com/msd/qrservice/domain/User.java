package com.msd.qrservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity(name = "user")
@Data
@NoArgsConstructor
public class User extends BaseEntityMaster {


    @Column(name = "user_name", unique = true, length = 100)
    private String username;
    @Column(length = 128)
    private String password;
    @Column(name = "access_token")
    private String accessToken;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id")
    private Role role;

}
