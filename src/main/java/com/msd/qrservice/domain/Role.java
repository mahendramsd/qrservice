package com.msd.qrservice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "role")
@Data
@NoArgsConstructor
public class Role implements Serializable {

    /**
     * role = 1   admin
     * user = 2  user
     */
    @Id
    private Integer id;

    @Column(name = "name", length = 50)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private List<User> userList;

}
