package com.practice.rest.service;

import com.practice.rest.advice.exception.CUserNotFoundException;
import com.practice.rest.repo.UserJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired UserJpaRepo userJpaRepo;

    @Override
    public UserDetails loadUserByUsername(String userPk) throws UsernameNotFoundException {
        return userJpaRepo
                .findById(Long.valueOf(userPk))
                .orElseThrow(CUserNotFoundException::new);
    }
}
