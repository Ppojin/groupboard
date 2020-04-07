package com.ppojin.groupboard.mapper;

import com.ppojin.groupboard.entity.user.UserEntity;
import com.ppojin.groupboard.service.UserService;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;

//CREATE TABLE `user` (
//        `userID`	int	NOT NULL	primary key auto_increment,
//        `email`	varchar(200)	NOT NULL,
//        `userName`	varchar(12)	NOT NULL,
//        `pwd`	varchar(60)	NOT NULL,
//        `birthday`	date	NULL,
//        `phone`	varchar(11)	NULL,
//        `joinDate`	datetime	NOT NULL	DEFAULT	CURRENT_TIMESTAMP,
//        `userImageUUID`	varchar(200)	NULL
//);
@Mapper
public interface UserMapper {
    @Select("SELECT * " +
            "FROM user WHERE email = #{email}")
    public UserEntity readUser(@Param("email") String email);

    @Insert("INSERT INTO PLAYER (email, userName, pwd, birthday, phone, userImageUUID)" +
            "VALUES (${email}, ${userName}, ${pwd}, ${birthday}, ${phone}, ${userImageUUID});")
    public UserEntity insertUser(
            @Param("email") String email,
            @Param("userName") String userName,
            @Param("pwd") String pwd,
            @Param("birthday") String birthday,
            @Param("phone") String phone,
            @Param("userImageUUID") String userImageUUID
    );

    public UserEntity readAuthority(String username);
}
