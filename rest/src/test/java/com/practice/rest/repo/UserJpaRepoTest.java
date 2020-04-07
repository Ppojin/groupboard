package com.practice.rest.repo;

import com.practice.rest.entity.User;
import com.practice.rest.security.SecurityConfiguration;
import com.practice.rest.service.CustomUserDetailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserJpaRepoTest {
    @Autowired private UserJpaRepo userJpaRepo;
    @Autowired private PasswordEncoder passwordEncoder;

    @Test
    public void whenFindByUid_thenReturnUser(){
        String uid = "ppojin@gmail.com";
        String name = "ppojin";
        //given
        userJpaRepo.save(User.builder()
                .uid(uid)
                .password(passwordEncoder.encode("qwer"))
                .name(name)
                .roles(Collections.singletonList("ROLE_USER"))
                .build()
        );
        //when
        Optional<User> user = userJpaRepo.findByUid(uid);
        //then
        assertNotNull(user);
        assertTrue(user.isPresent());
        assertEquals(user.get().getName(), name);
//        assertThat(user.get().getName(), is(name));
    }
}