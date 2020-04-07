package com.practice.rest.controller.v1;

import com.practice.rest.advice.exception.CUserNotFoundException;
import com.practice.rest.entity.User;
import com.practice.rest.model.response.CommonResult;
import com.practice.rest.model.response.ListResult;
import com.practice.rest.model.response.SingleResult;
import com.practice.rest.repo.UserJpaRepo;
import com.practice.rest.service.ResponseService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@Api(tags = {"1. User"})
//@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class UserController {
    @Autowired UserJpaRepo userJpaRepo;
    @Autowired ResponseService responseService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value="회원 리스트 조회", notes="모든 회원을 조회한다.")
    @GetMapping(value="/users")
    public ListResult<User> findAllUser(){
        return responseService.getListResult(
                userJpaRepo.findAll()
        );
    }

    @ApiImplicitParams({
            @ApiImplicitParam( name = "X-AUTH-TOKEN", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "회원 단건 조회", notes="userID로 회원을 조회한다")
    @GetMapping(value="/user")
    public SingleResult<User> findUserById(
            @ApiParam(value="언어", defaultValue="ko") @RequestParam String lang){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String id = authentication.getName();
        return responseService.getSingleResult(
                userJpaRepo.findByUid(id).orElseThrow(CUserNotFoundException::new)
        );
    }

    @ApiImplicitParams({
            @ApiImplicitParam( name = "X-AUTH-TOKEN", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value="회원 수정", notes="회원정보를 수정한다.")
    @PutMapping(value = "/user")
    public SingleResult<User> modify(
            @ApiParam(value = "회원번호", required = true) @RequestParam long msrl,
            @ApiParam(value = "회원이름", required = true) @RequestParam String name){
        User user = User.builder()
                .msrl(msrl)
                .name(name)
                .build();
        return responseService.getSingleResult(
                userJpaRepo.save(user)
        );
    }

    @ApiImplicitParams({
            @ApiImplicitParam( name = "X-AUTH-TOKEN", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header")
    })
    @ApiOperation(value = "회원 삭제", notes="userID로 회원정보를 삭제한다.")
    @RequestMapping(value = "/user/{msrl}", method = RequestMethod.DELETE)
    public CommonResult Delete(
            @ApiParam(value = "회원번호", required = true) @PathVariable long msrl){
        userJpaRepo.deleteById(msrl);
        return responseService.getSuccessResult();
    }
}