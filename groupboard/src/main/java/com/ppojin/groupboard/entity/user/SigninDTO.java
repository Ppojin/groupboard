package com.ppojin.groupboard.entity.user;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter @Setter
public class SigninDTO {
    private String email;
    private String pwd;
}
