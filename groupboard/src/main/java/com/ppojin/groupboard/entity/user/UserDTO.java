package com.ppojin.groupboard.entity.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.mindrot.jbcrypt.BCrypt;

import javax.validation.constraints.NotNull;
import java.sql.Date;

@RequiredArgsConstructor
@Getter @Setter @ToString
public class UserDTO {
    @NotNull private Integer userID;
    @NotNull private String email;
    @NotNull private String userName;
	@NotNull private String pwd;
    private Date birthday = null;
    private String phone = "";
    @NotNull private String userImageUUID;

    public void setPwd(String pwd) {
        String hashedPw = BCrypt.hashpw(pwd, BCrypt.gensalt());
        this.pwd = hashedPw;
    }
}
