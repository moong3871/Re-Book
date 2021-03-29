package com.necessafy.rebook.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRebook {
    @Id
    @Column(name="USER_EMAIL")
    private String email;

    //@JsonIgnore
    private String password;
    private String nickname;
    private String salt;

}
