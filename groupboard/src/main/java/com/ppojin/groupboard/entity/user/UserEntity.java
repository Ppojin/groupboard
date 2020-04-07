package com.ppojin.groupboard.entity.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.mindrot.jbcrypt.BCrypt;

import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Collection;

@RequiredArgsConstructor
@Getter @Setter
public class UserEntity {
    @NotNull private Integer userID;
    @NotNull private String email;
    @NotNull private String userName;
    private String pwd;
    private Date birthday;
    private String phone;
	@NotNull private String joinDate;
    @NotNull private String userImageUUID;
    private Collection authorities;

    public void getPwd() {}
    public boolean isCorrectPwd(@NotNull String pwd){
        return pwd == null || !BCrypt.checkpw(this.pwd, pwd);
    }
}
