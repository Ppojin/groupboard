package com.practice.rest.controller.v1;

import com.practice.rest.advice.exception.CEmailSigninFailedException;
import com.practice.rest.entity.User;
import com.practice.rest.model.response.CommonResult;
import com.practice.rest.model.response.SingleResult;
import com.practice.rest.repo.UserJpaRepo;
import com.practice.rest.security.JwtTokenProvider;
import com.practice.rest.service.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@Api(tags={"1. Sign"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class SignController {
    private final UserJpaRepo userJpaRepo;
    private final JwtTokenProvider jwtTokenProvider;
    private final ResponseService responseService;
    private final PasswordEncoder passwordEncoder;

    @ApiOperation(value = "로그인", notes="이메일 회원 로그인을 한다.")
    @PostMapping(value = "/signin")
    public SingleResult<String> signin(
            @ApiParam(value = "회원ID: 이메일", required = true) @RequestParam String id,
            @ApiParam(value = "비밀번호", required = true) @RequestParam String password){
           User user = userJpaRepo
                   .findByUid(id)
                   .orElseThrow(CEmailSigninFailedException::new);
           if(!passwordEncoder.matches(password, user.getPassword()))
               throw new CEmailSigninFailedException();

           return responseService.getSingleResult(
                   jwtTokenProvider.createToken(
                           String.valueOf(user.getMsrl()),
                           user.getRoles()
                   )
           );
    }

    @ApiOperation(value = "가입", notes = "회원강비을 한다.")
    @PostMapping(value = "/signup")
    public CommonResult signup(
            @ApiParam(value = "회원ID: 이메일", required = true) @RequestParam String id,
            @ApiParam(value = "비밀번호", required = true) @RequestParam String password,
            @ApiParam(value = "이름", required = true) @RequestParam String name){
        userJpaRepo.save(
            User.builder()
                .uid(id)
                .password(passwordEncoder.encode(password))
                .name(name)
                .roles(Collections.singletonList("ROLE_USER"))
                .build()
        );
        return responseService.getSuccessResult();
    }
}
