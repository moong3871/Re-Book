package com.necessafy.rebook.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.necessafy.rebook.model.TimeEntity;
import lombok.*;
//import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRebook extends TimeEntity {
    @Id
    @Column(name="USER_EMAIL")
    private String email;

    @JsonIgnore
    private String password;
    private String nickname;


    private String salt;

}
