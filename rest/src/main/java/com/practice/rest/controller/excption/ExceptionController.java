package com.practice.rest.controller.excption;

import com.practice.rest.advice.exception.CAuthenticationEntryPointException;
import com.practice.rest.model.response.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.AccessDeniedException;

@RestController
@RequestMapping(value = "/exception")
public class ExceptionController {
    @GetMapping(value = "/entrypoint")
    public CommonResult entrypointException(){
        throw new CAuthenticationEntryPointException();
    }
    @GetMapping(value = "/accessdenied")
    public CommonResult accessdeniedException() throws AccessDeniedException {
        throw new AccessDeniedException("");
    }
}
