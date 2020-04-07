package com.ppojin.groupboard.entity.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@AllArgsConstructor
@Getter @Setter
public class AuthTokenVO {
    private String userName;
    private Collection authorities;
    private String token;
}